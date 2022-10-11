import { createRouter, createWebHistory } from 'vue-router'
import PageHome from '@/views/PageHome.vue'
import BoardList from "@/views/board/BoardList";
import BoardDetail from "@/views/board/BoardDetail";
import BoardWrite from "@/views/board/BoardWrite"
import PageFileUpload from "@/views/file/PageFileUpload";
import PagePayment from "@/views/payment/PagePayment";

const routes = [
    {
        path: '/',
        name: 'PageHome',
        component: PageHome
    },
    {
        path: '/about',
        name: 'About',
        // route level code-splitting
        // this generates a separate chunk (about.[hash].js) for this route
        // which is lazy-loaded when the route is visited.
        component: () => import(/* webpackChunkName: "about" */ '../views/PageAbout.vue')
    },
    {
        path: '/board/list',
        name: 'BoardList',
        component: BoardList
    },
    {
        path: '/board/detail',
        name: 'BoardDetail',
        component: BoardDetail
    },
    {
        path: '/board/write',
        name: 'BoardWrite',
        component: BoardWrite
    },
    {
        path: '/file',
        name: 'PageFileUpload',
        component: PageFileUpload
    },
    {
        path: '/pay',
        name: 'PagePayment',
        component: PagePayment
    },


]

const router = createRouter({
    history: createWebHistory(process.env.BASE_URL),
    routes
})

export default router