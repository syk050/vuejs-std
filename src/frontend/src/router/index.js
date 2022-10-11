import { createRouter, createWebHistory } from 'vue-router'
import PageHome from '@/views/PageHome.vue'
import BoardList from "@/views/board/BoardList";
import BoardDetail from "@/views/board/BoardDetail";
import BoardWrite from "@/views/board/BoardWrite"
import PageFileUpload from "@/views/file/PageFileUpload";
import PaymentCertification from "@/views/payment/PaymentCertification";
import IamportTest from "@/views/payment/IamportTest"
import PaymentHome from "@/views/payment/PaymentHome";
import PaymentResult from "@/views/payment/PaymentResult";

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
        path: '/certification',
        name: 'PaymentCertification',
        component: PaymentCertification
    },
    {
        path: '/pay',
        name: 'IamportTest',
        component: IamportTest
    },
    {
        path: '/payment',
        name: 'PaymentHome',
        component: PaymentHome
    },
    {
        path: '/result',
        name: 'PaymentResult',
        component: PaymentResult
    },

]

const router = createRouter({
    history: createWebHistory(process.env.BASE_URL),
    routes
})

export default router