<template>
<el-dialog center title="登录" :show-close="false" :visible.sync="dialogFormVisible">
<el-form>
    <el-form-item label="用户名称" :label-width="formLabelWidth">
       <el-input autocomplete="on" v-model="user.username"></el-input>
    </el-form-item>
    <el-form-item label="用户密码" :label-width="formLabelWidth">
        <el-input v-model="user.password" type="password" autocomplete="on" ></el-input>
    </el-form-item>
</el-form>
 <div slot="footer" class="dialog-footer">
    <el-button type="primary" @click="login">登录</el-button>
 </div>
</el-dialog>
</template>
<script>
    export default {
        data() {
            return {
                formLabelWidth: "120px", //宽度
                dialogFormVisible: true,//是否关闭对话框
                user: {username: "", password: ""},//登录数据
            };
        },
        methods: {
            login()
            {
                //路由跳转到 CourseItem.vue组件
                this.$router.push("/index");
                /*
                //发送请求
                this.axios .get(url,
                { //携带参数
                  params: {
                      username: this.user.username,
                      password: this.user.password,
                   },
                })
                .then((res) => {
                   // console.log("successful"+res.data);
                    //成功就将对话框关闭
                    this.dialogFormVisible = false;
                    //跳转页面,前端跳转页面必须使用路由,使用$router对象中的push方法
                    this.$router.push('/index');
                })
                .catch((error) => {
                    //出现错误使用ElementUI提供的消息提示
                    this.$message.error("对不起! 登录错误!");
                });*/
            }
        }
    }
</script>

<style scoped>

</style>
