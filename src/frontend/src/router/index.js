import Vue from 'vue'
import VueRouter from 'vue-router'

import Board from 'BOARD/List.vue'
import BoardDetail from 'BOARD/Input.vue'
import BoardUpdate from 'BOARD/Update.vue'

Vue.use(VueRouter)

//주소에 맞게 어떤 컴포넌트를 표시할지 정의합니다.
const router = new VueRouter({
    mode: 'history',
    routes: [
        { path : '/board', component: Board },
        { path : '/board/new', component: BoardDetail },
        { path : '/board/update', component: BoardUpdate }
    ]
})

export default router