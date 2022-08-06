<template>
  <div id="app">
    <h1>Board Update</h1>
    <div class="container">
      <input type="hidden" v-model="board.id" />
      <div class="form-group">
        <p>제목</p>
        <input type="text" class="form-control" v-model="board.title"/>
      </div>
      <div class="form-group">
        <p>내용</p>
        <textarea class="form-control" v-model="board.content" rows="10"></textarea>
      </div>
      <div class="form-group">
        <button @click="update">수정</button>
        <button @click="$router.back()">돌아가기</button>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "BoardInfo",
  created() {
    this.fetchBoard()
  },
  data() {
    return {
      board: {
        message: '',
        id: '',
        title : '',
        content: ''
      }
    }
  },
  methods : {
    // 수정 페이지는 입력 페이지와 다르게 수정하고 싶은 게시물의 데이터를 먼저 가져와야 합니다.
    // fetchBoard 함수를 만들어서 created() 단계에서 데이터를 가져옵니다
    fetchBoard : function() {
      let pid = this.$route.query.id;
      if (!pid) return;
      this.$axios.get('/api/boards/' + pid)
          .then((response) => {
            this.board = response.data;
          })
          .catch((ex) => {
            console.error("not found board: ", ex);
          })
    },
    // 그리고 controller에 정의한대로 id 값과 board 값을 put으로 넘기면 수정이 됩니다
    update : function() {
      this.$axios.put('/api/boards/update/'+this.board.id, this.board)
          .then(() => {
            this.$router.push('/board')
          })
          .catch((ex) => {
            console.error("failed write article", ex)
          })
    }
  }
}
</script>