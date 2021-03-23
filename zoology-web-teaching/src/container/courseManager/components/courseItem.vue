<template>
    <section class="course-item">
        <!-- 头部 -->
        <div class="header">
            <!-- 返回上一页 -->
            <el-page-header
                    @back="() => this.$router.back()"
                    :content="title"
            />
        </div>
     <div align="center">
     <el-form ref="form" :model="courseInfo" :rules="rules" label-width="120px">
      <el-card
              shadow="never"
              v-loading="loading"
              element-loading-text="leader，我正在疯狂加载...."
      >
       <header slot="header">基本信息</header>
       <el-form-item label="课程名称" prop="course_name">
          <el-input
                      v-model="courseInfo.course_name"
                      type="text"
                      maxlength="50"
                      show-word-limit
           />
       </el-form-item>
       <el-form-item label="课程简介" prop="course_brief">
          <el-input
                      v-model="courseInfo.course_brief"
                      type="text"
                      maxlength="100"
                      show-word-limit
           />
        </el-form-item>
        <el-form-item label="课程课时数" prop="course_total_num">
          <el-input v-model="courseInfo.course_total_num" type="number">
             <template slot="append">个</template>
          </el-input>
        </el-form-item>
        <el-form-item label="课程总时长" prop="course_total_duration">
          <el-input v-model="courseInfo.course_total_duration" type="number">
              <template slot="append">分钟</template>
          </el-input>
        </el-form-item>
        <el-form-item label="讲师姓名" prop="teacher_name">
          <el-input
                      v-model="courseInfo.teacher_name"
                      type="text"
                      maxlength="40"
                      show-word-limit
          />
        </el-form-item>
        <el-form-item label="讲师等级:" prop="teacher_position" align="left">
          <el-select  v-model="courseInfo.teacher_position">
              <el-option label="高级讲师" value="高级讲师"></el-option>
              <el-option label="中级讲师" value="中级讲师"></el-option>
              <el-option label="低级讲师" value="低级讲师"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="讲师简介" prop="teacher_description">
          <el-input
                      v-model="courseInfo.teacher_description"
                      type="text"
                      maxlength="100"
                      show-word-limit
              />
        </el-form-item>
        <el-form-item label="课程预览">
          <el-input
                      v-model="courseInfo.course_preview_first_field"
                      type="text"
                      maxlength="20"
                      show-word-limit
          />
          <el-input
                      v-model="courseInfo.course_preview_second_field"
                      type="text"
                      maxlength="20"
                      show-word-limit
          />
        </el-form-item>
        <el-form-item label="课程新旧:" prop="course_is_new" align="left">
          <el-select  v-model="courseInfo.course_is_new">
             <el-option label="是" value="0"></el-option>
             <el-option label="不是" value="1"></el-option>
          </el-select>
        </el-form-item>
      </el-card>
      <el-card  shadow="never"
                v-loading="loading"
                element-loading-text="leader，我正在疯狂加载...."
      >
          <header slot="header">销售信息</header>
          <el-form-item label="课程原价" prop="course_price">
              <el-input v-model="courseInfo.course_price" type="number":controls="false">
                  <template slot="append">元</template>
              </el-input>
          </el-form-item>
          <el-form-item label="课程原价标签" prop="course_price_tag">
              <el-input
                      v-model="courseInfo.course_price_tag"
                      type="text"
                      maxlength="4"
                      show-word-limit
              />
          </el-form-item>
          <el-form-item label="课程优惠价" prop="course_discounts">
              <el-input v-model="courseInfo.course_discounts" type="number">
                  <template slot="append">元</template>
              </el-input>
          </el-form-item>
          <el-form-item label="课程优惠标签" prop="course_discounts_tag">
              <el-input
                      v-model="courseInfo.course_discounts_tag"
                      type="text"
                      maxlength="4"
                      show-word-limit
              />
          </el-form-item>
          <el-form-item label="课程广告语" prop="course_is_new_des">
              <el-input
                      v-model="courseInfo.course_is_new_des"
                      type="text"
                      maxlength="100"
                      show-word-limit
              />
          </el-form-item>
          <el-form-item label="销售量" prop="course_sale">
              <el-input v-model="courseInfo.course_sale" type="number">
                  <template slot="append">个</template>
              </el-input>
          </el-form-item>
      </el-card>
      <el-card  shadow="never"
                 v-loading="loading"
                 element-loading-text="leader，我正在疯狂加载...."
       >
          <header slot="header">分享信息</header>
          <el-form-item label="分享标题" prop="course_share_img_title">
              <el-input
                      v-model="courseInfo.course_share_img_title"
                      type="text"
                      maxlength="100"
                      show-word-limit
              />
          </el-form-item>
           <el-form-item label="分享简介" prop="course_share_img_brief">
            <el-input
                         v-model="courseInfo.course_share_img_brief"
                         type="text"
                         maxlength="40"
                         show-word-limit
                 />
           </el-form-item>
         </el-card>
         <el-card
                 shadow="never"
                 v-loading="loading"
                 element-loading-text="leader，我正在疯狂加载...."
         >
             <header>课程详情</header>
             <el-form-item prop="course_description">
                 <editor v-model="courseInfo.course_description" />
             </el-form-item>
         </el-card>
         <el-card
                 shadow="never"
                 v-loading="loading"
                 element-loading-text="leader，我正在疯狂加载...."
         >
             <el-form-item label="备注" prop="remark">
                 <el-input
                         v-model="courseInfo.remark"
                         type="text"
                         maxlength="100"
                         show-word-limit
                 />
             </el-form-item>
         </el-card>
         <el-card>
          <template scope="scope">
              <el-button type="primary" @click="saveOrEditCourse()" class="agreeBtn actionBtn">保存</el-button>
              <el-button type="success" class="refuseBtn actionBtn">取消</el-button>
          </template>
         </el-card>
     </el-form>
    </div>
    </section>
</template>
<script>
//引入文件上传和富文本编辑器
import UploadImage from "@/components/UploadImage";
import Editor from "@/components/Editor.vue";
    export default {
        name: "courseItem",
        title:"课程信息",
        //注册组件
        components: {
            Editor,
            UploadImage
        },
        data() {
            //表单校验规则
            const rules = {
                course_name: [
                    { required: true, message: "请输入课程名称", trigger: "blur" },
                    { min: 1, max: 50, message: "长度在 1 到 50 个字符", trigger: "blur" }
                ],
                course_brief: [
                    { required: true, message: "请输入课程简介", trigger: "change" },
                    { min: 1, max: 100, message: "长度在 1 到 100 个字符", trigger: "blur" }
                ],
                course_total_num: [{ required: true, message: "请输入课程课时数", trigger: "change" }],
                course_total_duration: [{ required: true, message: "请输入课程总时长", trigger: "change" }],
                teacher_name: [
                    { required: true, message: "请输入讲师姓名", trigger: "change" },
                    { min: 1, max: 50, message: "长度在 1 到 50 个字符", trigger: "blur" }
                ],
                teacher_position: [{ required: true, message: "请输入讲师等级", trigger: "change" }],
                teacher_infor: [
                    { required: true, message: "请输入讲师简介", trigger: "change" },
                    { min: 1, max: 50, message: "长度在 1 到 50 个字符", trigger: "blur" }
                ],
                course_preview_first_field: [
                    { required: true, message: "请输入第一段的课程预览", trigger: "change" },
                    { min: 1, max: 20, message: "长度在 1 到 20 个字符", trigger: "blur" }
                ],
                course_preview_second_field: [
                    { required: true, message: "请输入第二段的课程预览", trigger: "change" },
                    { min: 1, max: 20, message: "长度在 1 到 20 个字符", trigger: "blur" }
                ],
                course_price: [{ required: true, message: "请输入课程原价", trigger: "change" }],
                course_price_tag: [
                    { required: true, message: "请输入课程原价标签", trigger: "change" },
                    { min: 1, max: 20, message: "长度在 1 到 20 个字符", trigger: "blur" }
                ],
                course_discounts: [{ required: true, message: "请输入课程优惠价", trigger: "change" }],
                course_discounts_tag: [
                    { required: true, message: "请输入课程优惠价标签", trigger: "change" },
                    { min: 1, max: 20, message: "长度在 1 到 20 个字符", trigger: "blur" }
                ],
                course_is_new_des: [
                    { required: true, message: "请输入课程广告语", trigger: "change" },
                    { min: 1, max: 20, message: "长度在 1 到 20 个字符", trigger: "blur" }
                ],
                course_sale: [{ required: true, message: "请输入课程销售量", trigger: "change" }],
                course_share_img_title: [
                    { required: true, message: "请输入分享标题", trigger: "change" }
                ],
                course_share_img_brief: [
                    { required: true, message: "请输入分享简介", trigger: "change" }
                ]
            };
            //上传文件信息
            const fileUploadinfo = {
                uid:"",
                name:""
            };
            return {
                rules,//定义规则
                title:"",//功能标题
                course_id:"",//功能值
                courseInfo: {},//课程信息
                loading:false,//默认关闭加载提示
                params:{},//j交换器
            };
        },
        created(){
          //1.从路由中获取传递的参数, 课程id
          const courseId=this.$route.params.courseId;
          if (!courseId) {
             return this.redirectToError()
          }else if (courseId==="new") {
           //new代表新增
           //课程修改
           this.title="课程新增";
           this.course_id="";
          }else {
           //课程修改
           this.title="课程修改";
           this.course_id=courseId;
           this.loadCourse(this.course_id);
          }
          //创建FormData对象,将图片与表单一同上传
         //  this.params = new FormData();
        },
        methods: {
          saveOrEditCourse(courseInfo) {
             //开启加载启示
             this.loading=true;
             //检查是否拿到了form数据
             if (JSON.stringify(courseInfo)!="") {
                  this.params = this.courseInfo;
                  this.$addr.post("saveOrEditCourseAndTeacher",this.params).then((res)=>{
                  this.loading=false;
                  this.$router.push("/courseList");
                })
                .catch(error=>{
                    this.$message.error("保存或修改失败!!!!");
                });
             }else {
                 alert("请输入内容");
             }
         },
         //通过course_id回显course课程信息
         loadCourse(course_id){

          //开启加载启示
          this.loading = true;
          this.$addr.get("findCourseAndTeacherByCourseId/"+course_id).then((res)=>{
              //关闭加载数据提示
              this.loading = false;
              this.courseInfo = res.data.content;
          }) .catch(error=>{
              this.$message.error("回显数据失败!!!!");
          });
         },
         //跳转到错误
         redirectToError() {
           // TODO: Error components
            this.$router.replace({ path: "/not-found" });
         }
        }
    }
</script>
<style lang="scss">
    .course-item {
    .header {
        display: flex;
        justify-content: space-between;
        align-items: center;
    }

    .el-card {
        margin-top: 20px;
    }

    .form-control-summary {
    .el-form-item__content {
        display: flex;
        justify-content: space-between;

    .el-input {
        width: 49%;
    }

    &:before,
    &:after {
         display: none;
     }
    }
    }

    .actions {
        display: flex;
        justify-content: center;

    .el-button {
        margin: 40px 20px;
    }
    }
    }
</style>

