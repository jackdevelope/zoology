/*
1.4.2 App.vue
2. App.vue 是vue项目的主组件，是页面入口文件 ，所有页面都是在App.vue下进行切换的
1.4.3 router 路由
3. 找到路由文件,来看一下具体的路由配置
html文件中，通过script src = 'xxx'标签引入js文件。 而vue中，通过 import 变量名 from 文件路径 的方式导入文件，不光可以导入js文件。 1.变量名: 指的是为导入的文件起一个名称，不是指导入的文件的名称，相当于变量名。 2.文件路径: 指的是文件的相对路径
 */
//导入vue
import Vue from 'vue'
import App from './App.vue'
//导入vuex
import Vuex from 'vuex'
import store from './store/store'
import router from './router'
//引入axios
import axios from 'axios'
//导入ElementUI组件库
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
//导入vue-simplemde
import VueSimplemde from 'vue-simplemde'
import 'simplemde/dist/simplemde.min.css'
//配置Vue插件 将Vuex安装到Vue上
Vue.use(Vuex)
//配置Vue插件 将VueSimplemde安装到Vue上
Vue.use(VueSimplemde)
//配置Vue插件 将El安装到Vue上
Vue.use(ElementUI)
//Vue对象使用axios
Vue.prototype.axios = axios;
//使用axios设置网址头
axios.defaults.baseURL = 'http://localhost:8080/zoology_teaching_web_war/';//关键步骤–填写后台请求统一的地址
Vue.config.productionTip = false;//关闭启动提示
Vue.prototype.$addr = axios;
//创建Vue实例
new Vue({
    el: '#app',//挂载的是App.vue组件中的id为app的区域
    router,//为整个项目添加路由
    store,
    render: h => h(App)//这是一个函数ES6语法,作用是生成模板: App = App.vue
})
