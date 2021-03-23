<template>
        <el-container style="height: 100%; width: 100%" direction="vertical" >  
            <el-header>后台管理</el-header>
            <div align="center">
              <el-breadcrumb  separator-class="el-icon-arrow-right" align="left">
                <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
                <el-breadcrumb-item>课程管理</el-breadcrumb-item>
              </el-breadcrumb>
            </div>
            <el-container align="center" style="width: 100%">
                <!-- 侧边栏 -->
                <el-aside width="200px">
                    <el-menu
                            default-active="2"
                            class="el-menu-vertical-demo"
                            background-color="#d3dce6"
                            router
                    >
                        <el-submenu index="1">
                            <template slot="title">
                                <i class="el-icon-location"></i>
                                <span>导航菜单</span>
                            </template>
                            <el-menu-item-group>
                                <!-- 修改 index的路由地址 -->
                                <el-menu-item index="/courseList">
                                    <i class="el-icon-menu"></i>课程管理
                                </el-menu-item>
                            </el-menu-item-group>
                            <el-menu-item-group>
                                <!-- 修改 index的路由地址 -->
                                <el-menu-item index="/upload">
                                    <i class="el-icon-menu"></i>图片上传
                                </el-menu-item>
                            </el-menu-item-group>
                            <el-menu-item-group>
                                <!-- 修改 index的路由地址 -->
                                <el-menu-item index="/test">
                                    <i class="el-icon-menu"></i>测试组件的引入
                                </el-menu-item>
                            </el-menu-item-group>
                            <el-menu-item-group>
                                <!-- 修改 index的路由地址 -->
                                <el-menu-item index="/page">
                                    <i class="el-icon-menu"></i>分页组件
                                </el-menu-item>
                            </el-menu-item-group>
                            <el-menu-item-group>
                                <!-- 修改 index的路由地址 -->
                                <el-menu-item index="/date">
                                    <i class="el-icon-menu"></i>日期控件
                                </el-menu-item>
                            </el-menu-item-group>
                        </el-submenu>
                    </el-menu>
                </el-aside>
                <el-container>
                    <el-main><router-view></router-view></el-main>
                </el-container>
            </el-container>
        </el-container>
</template>
<script>
    export default {
        name: "index",
        title:"布局首页",
        search:''
    }
</script>
<style scoped>
    .el-scrollbar__wrap {
        overflow-x: hidden;
    }
    .el-container {
        height: 725px;
        min-height: 100%;
        width: 100%;
    }
    .el-header,
    .el-footer {
        background-color: #b3c0d1;
        color: #333;
        text-align: center;
        line-height: 100%;
        width: 100%;
        height: 100%;
    }
    .el-aside {
        background-color: #d3dce6;
        color: #333;
        text-align: center;
        line-height: 100%;
        height: 100%;
        width: 100%;
    }
    .el-main {
        background-color: #e9eef3;
        color: #333;
        text-align: center;
        line-height: 100%;
        height: 100%;
        width: 100%;
    }
</style>
