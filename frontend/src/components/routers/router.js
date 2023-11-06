import {createRouter, createWebHistory} from "vue-router";
import HomePage from "@/components/pages/HomePage.vue";
import LoginPage from "@/components/pages/LoginPage.vue";
import RegisterPage from "@/components/pages/RegisterPage.vue";
import AdminAccount from "@/components/pages/account/AdminAccount.vue";
import EmployeeAccount from "@/components/pages/account/EmployeeAccount.vue";


const routes = [
    {
        path: '/',
        component: HomePage
    },
    {
        path: '/login',
        component: LoginPage
    },
    {
        path: '/register',
        component: RegisterPage
    },
    {
        path: '/account/admin',
        component: AdminAccount
    },
    {
        path: '/account/employee',
        component: EmployeeAccount
    }
]

const router = createRouter({
    routes,
    history: createWebHistory(process.env.BASE_URL)
})

export default router;