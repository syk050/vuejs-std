<template>
  <div>
    <h3>파일 업로드 결과: {{ this.response === '' ? 'waiting' : this.response }}</h3>
    <div>
      <button @click="selectUploadFile()">이미지 선택</button>
    </div>
  </div>

</template>

<script>
export default {
  name: "PageFileUpload",
  data() {
    return {
      response: ''
    }
  },
  methods: {
    selectUploadFile() {
      const vue = this;
      const axios = this.$axios
      let elem = document.createElement('input')
      let apiUrl = this.$serverUrl + '/file'
      // 이미지 파일 업로드 / 동시에 여러 파일 업로드
      elem.id = 'image'
      elem.type = 'file'
      elem.accept = 'image/*'
      elem.multiple = true
      // 클릭
      elem.click();
      // 이벤트 감지
      elem.onchange = function() {
        const formData = new FormData()
        for (let index = 0; index < this.files.length; index++) {
          formData.append('fileList', this.files[index])
        }

        axios.post(apiUrl, formData, {
          headers: { 'Content-Type': 'multipart/form-data' }
        }).then(response => {
          vue.response = response.data
        }).catch(error => {
          vue.response = error.message
        });
      }
    },
  }
}
</script>

<style scoped>

</style>