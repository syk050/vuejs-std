import './assets/common.css'

import { createApp } from 'vue'
import App from './App.vue'
import router from "./router";
import axios from "axios";
import CKEditor from '@ckeditor/ckeditor5-vue';

const app = createApp(App)

app.config.globalProperties.$axios = axios;
app.config.globalProperties.$serverUrl = "http://localhost:8081";

// #app => index.html에 있는 id가 app인 곳에 표현
// app.use(router).mount('#app')
app.use(CKEditor).use(router).mount('#app')