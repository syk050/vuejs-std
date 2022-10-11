import './assets/common.css'

import { createApp } from 'vue'
import App from './App.vue'
import router from "./router";
import axios from "axios";
import CKEditor from '@ckeditor/ckeditor5-vue';
import Antd from 'ant-design-vue';

const app = createApp(App)

app.config.globalProperties.$axios = axios;
app.config.globalProperties.$serverUrl = "http://localhost:8081";

app.config.productionTip = false;

// #app => index.html에 있는 id가 app인 곳에 표현
app.use(router).use(Antd).mount('#app')
app.use(CKEditor).mount('#ckeditor')