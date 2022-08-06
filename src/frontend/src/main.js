import './assets/common.css'

import { createApp } from 'vue'
import App from './App.vue'
import router from "./router";

const app = createApp(App)
// #app => index.html에 있는 id가 app인 곳에 표현
app.use(router).mount('#app')