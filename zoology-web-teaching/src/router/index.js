// 引入所需文件
import Vue from 'vue'
import Router from 'vue-router'
import Index from '@/container/index.vue'
Vue.use(Router)
//创建路由规则
export const constantRoutes = [
    {
        path: '/',           //这个表示的是根目录，即一进入的页面
        redirect: 'login'    //设置页面一进来就显示的页面，即重定向到goods组件，这里写的内容是对应组将的component的值
    },
     //登录
    {
      path:'/login',
      component: () => import("@/views/login.vue"),
    },
    //布局路由
    {
        path:'/index',
        name:'index',
        component: Index,
        children:[
            {
                path:"/courseList",
                name: "courseList",
                component: () =>import("@/container/courseManager/components/courseList.vue")
            },
            {
                path: "/courseItem/:courseId", //路径,携带参数: 课程ID
                name: "courseItem",
                component: () =>import("@/container/courseManager/components/courseItem.vue")
            },
            {
                path: "/courseContentItem/:courseId", //路径,携带参数: 课程ID
                name: "courseContentItem",
                component: () =>import("@/container/courseManager/components/courseContentItem.vue")
            },
            {
                path: "*",
                component: () =>import("@/views/Error.vue")
            }
        ]
    },
]
//创建路由管理器,管理routes
const createRouter = () => new Router({
    // mode: 'history', // require service support
    scrollBehavior: () => ({ y: 0 }),
    routes: constantRoutes
})
const router = createRouter()

//export 用来导出模块 router就代表了整个路由文件
export default router
