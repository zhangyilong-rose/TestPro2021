import Vue from 'vue'
import Router from 'vue-router'
import Login from '../views/Login'
import Main from '../views/Main'
import Test1 from '../views/MainTest/Test1'
import Test2 from '../views/MainTest/Test2'

Vue.use(Router)


export default new Router({
    routes: [{//登录
        path: '/login',
        name: 'Login',
        component: Login
    }, {//首页
        path: '/main',
        name: 'Main',
        component: Main,
        children: [
            {
                //单个接口测试
                path: '/test1',
                name: 'Test1',
                component: Test1
            }, {//批量接口测试
                path: '/test2',
                name: 'Test2',
                component: Test2
            },

        ]
    },
    {
        path: '/Home',
        component: resolve => require(['../components/Home.vue'], resolve),
        children:[
            {
                path:'/Info',
                component:resolve => require(['../views/Info.vue'],resolve)
            },
            {
                path:'/Info1',
                component:resolve => require(['../views/Info1.vue'],resolve)
            },
            {
                path:'/Info2',
                component:resolve => require(['../views/Info2.vue'],resolve)
            },
            {
                path:'/Info3',
                component:resolve => require(['../views/Info3.vue'],resolve)
            },
        ]
    },
    
    ]
})