<template>
<section class="course" id="tabContainer" style="height:100%;width:100%;">
    <!-- 功能栏部分-->
    <el-form align="left" class="actions" :inline="true">
        <el-form-item class="input-title" label="课程名称:">
            <el-input v-model="filter.course_name" type="search" placeholder="课程名称"></el-input>
        </el-form-item>
        <el-form-item label="课程状态:">
            <el-select v-model="filter.course_status" placeholder="课程状态">
                <el-option label="全部" value=""></el-option>
                <el-option label="已发布" value="1"></el-option>
                <el-option label="草稿" value="0"></el-option>
            </el-select>
        </el-form-item>
        <el-form-item>
            <el-button @click="selSignCourse">查询</el-button>
        </el-form-item>
        <el-form-item align="right" class="btn-add" label-position="right">
            <el-button align="right" type="primary" icon="el-icon-plus" @click="toNewSaleCourseItem">新建课程</el-button>
        </el-form-item>
    </el-form>
    <!-- 展示部分,即数据显示部分 -->
    <el-table  style="width: 100%; height: 100%;
    "
      border height="100%" width="100%"
      :data="courseList"
      v-loading="loading"
      element-loading-text="leader，我正在疯狂加载...."
      align="center"
    >
        <el-table-column  prop="course_id" label="ID" v-if="show" align="center"></el-table-column>
        <el-table-column  prop="course_num" label="课程编号" width="84" align="center"></el-table-column>
        <el-table-column  prop="course_name" label="课程名" width="150" align="center"></el-table-column>
        <el-table-column  prop="course_img_url" label="课程图片" width="240" align="center"></el-table-column>
        <el-table-column  prop="course_brief" label="课程简介" width="140" align="center"></el-table-column>
        <el-table-column  prop="course_price" label="原价" width="65" align="center" :formatter="priceFormatter"></el-table-column>
        <el-table-column  prop="course_discounts" label="优惠价" width="65" align="center" :formatter="priceFormatter"></el-table-column>
        <el-table-column  prop="course_create_auto_online_time" label="自动上架时间" width="240" align="center"></el-table-column>
        <el-table-column  prop="course_create_auto_finish_online_time" label="自动下架时间" width="240" align="center"></el-table-column>
        <el-table-column  prop="course_status" label="状态" width="80" align="center">
            <template slot-scope="scope">
                <i class="status status-success" v-if="scope.row.course_status==1" title="已发布" style="color: red">已发布</i>
                <i class="status status-warning" v-else-if="scope.row.course_status==0" title="草稿" style="color: green">草稿</i>
            </template>
        </el-table-column>
        <el-table-column  prop="course_sort_num" label="排序" width="50" align="center"></el-table-column>
        <el-table-column  label="操作" width="350px" align="center">
          <template scope="scope">
            <el-row>
              <el-button size="mini" :type="scope.row.course_status == '1'?'danger':'success'"  @click="editCourseStatus(scope.row)">
                {{scope.row.course_status == '1'?"下架":"发布"}}
              </el-button>
              <el-button size="mini"
                          type="success"
                          @click="toEditSaleCourseItem(scope.row)">营销信息</el-button>
              <el-button size="mini"
                          type="success"
                          @click="toCourseContentItem(scope.row)">内容管理</el-button>
              <el-button size="mini"
                          type="danger"
                          @click="allCourseInfoDelete(scope.row)">删除信息</el-button>
            </el-row>
          </template>
        </el-table-column>
    </el-table>
</section>
</template>
<script>

    export default {
       name: "course",
       title: "课程管理",
      //数据部分
       data(){
           //查询条件    
           const filter = {
               course_name: "",
               course_status: ""
           };
           return{
           //使用查询条件
            filter,
            //定义数据
            courseList: [],//定义集合,保存从接口获取的参数
            loading: false,//是否弹出加载提示
            show:false,//开启隐藏
          };
       },
      //钩子函数,在页面生成之前, 调用loadCourse
       created() {
         this.loadCourse();
       },
       methods: {
        //加载课程信息
        loadCourse() {
           //开启加载启示
            this.loading=true;
           //定义外部this
            var arr = this;
           //访问后台接口,获取数据并返回
            return this.$addr.get("findCourse").then((res)=>{
           //将获取到的数据赋值给 courseList
            arr.courseList=res.data;
            this.loading=false;
          })
          .catch(error=>{
            this.$message.error("获取数据失败");
          });
        },
        //条件查询课程信息
        selSignCourse(){
           //开启加载启示
            this.loading=true;
           //alert(this.filter.course_name+this.filter.course_status);
           //定义查询条件对象
            const search = {};
           //检查是否存在空参数
            if (this.filter.course_name)search.course_name = this.filter.course_name;else alert("请给出请求参数!")
            if (this.filter.course_status)search.course_status = this.filter.course_status;else alert("请给出请求参数!")
            this.$addr.post("findCourseByNameAndStatus",
               //携带参数
                {
                    course_name:search.course_name,
                    course_status:search.course_status
                }
            ).then((res)=>{
                //将获取的数据给data
                 //alert(res.data.content);
                //alert(param)
                this.courseList=res.data.content;
                //取消加载
                this.loading=false;
            }).catch((error=>{
                //错误
                this.$message.error("对不起!请求错误！");
            }));
        },
        //切换到课程营销组件
        toNewSaleCourseItem(){
          //路由跳转到 CourseItem.vue组件
          this.$router.push({ name: "courseItem", params: { courseId: "new" } });
        },
        toEditSaleCourseItem(item){
          const courseId=item.course_id;
          //路由跳转到 CourseItem.vue组件
          this.$router.push({ name: "courseItem", params: { courseId: courseId } });
        },
       //跳转到课程内容组件
       toCourseContentItem(item){
           const courseId=item.course_id;
           //路由跳转到 CourseItem.vue组件
           this.$router.push({ name: "courseContentItem", params: { courseId: courseId } });
       },
       //修改课程状态
       editCourseStatus(item) {
         //设置最新状态
         const toggledStatus = 1-item.course_status;
         //请求后台接口
         this.$addr.put("editCourseStatus/"+item.course_id+"/"+toggledStatus)
             .then(res=>{
               debugger;
               //设置最新的值
               item.course_status=toggledStatus;
               //重新加载页面
               window.location.reload;
              })
              .catch(error=>{
               this.$message.error("状态修改失败了!!!!")
              });
         },
         //删除课程以及所有课程相关信息
         allCourseInfoDelete(scope) {
             //开始删除
             this.$addr.delete("removeCourse/"+scope.course_num).then(res=>{
                //更新页面
                this.courseList.splice(scope.indent,1);
             })
             .catch(error=>{
                 this.$message.error("课程删除失败了!!!!")
             });
         },
         //价格前面添加¥方法
         priceFormatter(row,column,value,index){
          return '¥'+value;
         }
       }
    };
</script>
<style>

</style>

