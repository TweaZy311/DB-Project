import "bootstrap/dist/css/bootstrap.css"
import "bootstrap/dist/js/bootstrap.js"
import { createApp } from 'vue'
import App from './App.vue'
import UIComponents from '@/components/UI'
import router from '@/components/routers/router'
import store from "@/components/store";


const app = createApp(App);

UIComponents.forEach(component => {
    app.component(component.name, component)
})

app.use(router)
    .use(store)
    .mount('#app')
