<template>
<section class="course-tasks">
    <!-- 头部 -->
    <div class="header">
        <!-- 显示当前课程的名称 -->
        <el-page-header @back="() => this.$router.back()" :content="fromCourseInfor.course_name" />
        <!-- 添加章节按钮 -->
        <el-button type="primary" icon="el-icon-plus" @click="addCourseConntent(this.operSec)">添加章节</el-button>
    </div>
    <!-- 树形控件,展示课程对应的章节信息 -->
    <el-tree
            :data="sections"
            :props="treeProps"
            v-loading="loading"
            element-loading-text="leader，我正在疯狂加载...."
    >
        <!-- slot-scope:代表当前树节点内容,有两个参数 data表示当前树节点, node表示当前节点状态 -->
        <div class="inner" slot-scope="{ data, node }">
           <span>{{ data.course_section_name || data.course_lesson_theme}}</span>
            <!--操作按钮-->
           <span class="actions">
           <!-- 编辑章节  @click.stop 阻止事件冒泡 -->
            <el-button v-if="node.level == 1"  size="small" @click.stop="addCourseConntent()">编辑</el-button>
                <!-- 增加课时 -->
            <el-button v-if="node.level == 1" size="small" type="primary" @click.stop="addCourseConntent(this.operles)">添加课时</el-button>
               <!-- 编辑课时 -->
            <el-button v-if="node.level == 1" size="small" type="primary" @click.stop="addCourseConntent(data)">编辑课时</el-button>
                <!--章节状态设置-->
            <el-button v-if="node.level == 1"  size="small" @click.stop="showSectionStatus(data)">{{statusMapping[data.course_section_status]}}</el-button>
          </span>
        </div>

    </el-tree>
    <!-- 修改章节状态-对话框 -->
    <el-dialog class="toggle-dialog" title="提示" :visible.sync="showStatusForm" width="30%">
        <header class="toggle-header">
            <i class="el-icon-info"></i>
            <span>
          当前状态：{{
          selSectionTemp.course_section_status && statusMapping[selSectionTemp.course_section_status]
          }}
        </span>
        </header>
        <el-form label-position="right" label-width="110px" :model="selSectionTemp">
            <el-form-item label="状态变更为：">
                <el-select v-model="selSectionTemp.course_section_status" style="width: 100%">
                    <el-option
                            v-for="(item,index) in Object.keys(statusMapping)"
                            :key="index"
                            :label="statusMapping[item]"
                            :value="item"
                    ></el-option>
                </el-select>
            </el-form-item>
        </el-form>

        <span slot="footer" class="dialog-footer">
        <el-button @click="showStatusForm = false">取 消</el-button>
        <el-button type="primary" @click="updateStatus">确 定</el-button>
      </span>
    </el-dialog>
    <!-- 添加或修改章节 -->
    <el-dialog class="add-dialog" title="章节信息" :visible.sync="showAddSection">
        <el-form
                label-position="right"
                label-width="80px"
                ref="selSectionTemp"
                :model="selSectionTemp"
        >
            <el-form-item label="课程编号" prop="course_num">
                <el-input v-model="selSectionTemp.course_num" disabled></el-input>
            </el-form-item>
         <el-form-item label="课程名称" prop="course_name">
            <el-input v-model="selSectionTemp.course_name" disabled></el-input>
         </el-form-item>
         <el-form-item label="章节名称" prop="section_name">
            <el-input v-model="selSectionTemp.course_section_name"></el-input>
         </el-form-item>
         <el-form-item label="章节描述" prop=".course_section_description">
            <el-input type="textarea" v-model="selSectionTemp.course_section_description"></el-input>
         </el-form-item>
         <el-form-item label="章节排序" prop="order_num">
            <el-input v-model="selSectionTemp.course_section_order_num" type="number">
               <template slot="append">数字控制排序，数字越大越靠后</template>
            </el-input>
         </el-form-item>
        <div class="tableTitle"><span class="midText">费用说明</span></div>
        <el-form-item label="课程名称" prop="course_name">
            <el-input v-model="selLessionTemp.course_name" disabled></el-input>
        </el-form-item>
        <el-form-item label="章节名称" prop="course_section_name">
            <el-input v-model="selLessionTemp.course_section_name"></el-input>
        </el-form-item>
        <el-form-item label="课时主题" prop="course_lesson_theme">
            <el-input type="textarea" v-model="selLessionTemp.course_lesson_theme"></el-input>
        </el-form-item>
        <el-form-item label="时长" prop="course_lesson_duration">
            <el-input v-model="selLessionTemp.course_lesson_duration" type="number">
                <template slot="append">分钟</template>
            </el-input>
        </el-form-item>
      </el-form>
    </el-dialog>
</section>
</template>
<script>
    export default {
        name: "CourseTasks",
        title: "课程结构",
        data() {
            //定义章节状态信息
            const statusMapping = {
                0: "已隐藏",
                1: "待更新",
                2: "已更新"
            };
            //定义对应课程信息
            const fromCourseInfor = {
                course_id: "",
                course_num:"",
                course_name: ""
            };
            //章节与课时信息,树形结构
            const treeProps = {
                label: item => {
                    return item.course_section_name ;
                },
                children: "courseLessons"
            };
            //定义章节回显集
            const selSectionTemp = {
               course_num:"",
               course_name: "",
               course_section_num:"",
               course_section_name:"",
               course_section_description:"",
               course_section_status:"",
               course_section_order_num:"",
               remark:""//备注
            }
            //定义课时回显集
            const selLessionTemp = {
               course_name:"",
               course_section_name:"",
               course_lesson_theme:"",
               course_lesson_duration:"",
               course_lesson_is_free:"",
               course_lesson_order_num:""
            }
            return {
                operles:"new lession",
                fromCourseInfor,//定义对应课程信息
                treeProps,//章节课时树
                sections: [],//章节课时树集合
                selSectionTemp,//章节回显集
                selLessionTemp,//课时回显集
                statusMapping,//定义章节状态
                loading: false, ////是否弹出加载提示
                showAddSection: false, //是否显示添加或修改章节
                showStatusForm: false, //是否显示状态修改
                showAddLession:false //是否显示添加或修改课时
            };
        },
        created() {
            //从路由中获取传递的参数courseId
            const course_Id = this.$route.params.courseId;
            if (course_Id==""){ return this.redirectToError()}
            else {
                //加载课程信息
                this.loadCourse(course_Id);
                //加载课程对应的章节与课时
                this.loadChildren(course_Id);
            }
        },
        methods: {
         //加载课程信息
         loadCourse(course_id) {
             //开启加载启示
             this.loading=true;
          this.$addr.get("findSignCourseByCourseId/"+course_id)
              .then(res => {
                  //将数据保存到表单对象中
                this.fromCourseInfor.course_id = res.data.content.course_id;
                this.fromCourseInfor.course_num=res.data.content.course_num;
                this.fromCourseInfor.course_name = res.data.content.course_name;
                this.loading=false;
              })
              .catch(error => {
                this.$message.error("数据获取失败! ! !");
                this.loading=false;
              });
            },
        //加载树(章节与课时)
        loadChildren(course_Id) {
          var course_Id=course_Id
          //开启加载启示
          this.loading = true;
          this.$addr.get("findCourseContentByCourseId/"+course_Id)
              .then(res=> {
                this.sections = res.data.content;
                this.loading = false;
              })
              .catch(error => {
                this.$message.error("数据获取失败! ! !");
                this.loading=false;
              });
            },
        //章节回显方法
        showCourseSection(section) {
          Object.assign(this.selSectionTemp, section);
          this.showAddSection = true;
        },
        //添加&修改章节操作
        addCourseConntent(sign) {
          //开启前端加载提示
          this.loading=true;
           if (sign=="new Sections"){
             this.$addr.post("saveOrEditCourseContent",this.selSectionTemp)
                   .then(res=>{
                       this.showAddSection = false;
                       //重新加载列表
                       return this.loadChildren(this.selSectionTemp.course_id);
                   })
                   .catch(error => {
                       //开启加载启示
                       this.loading=true;
                       this.$message.error("章节添加失败! ! !");
                       this.loading=false;
                   });
           }else if (sign=="new lession") {
               this.$addr.post("saveOrEditCourseContent",this.selSectionTemp)
                   .then(res=>{
                       this.showAddSection = false;
                       //重新加载列表
                       return this.loadChildren(this.selSectionTemp.course_id);
                   })
                   .catch(error => {
                       //开启加载启示
                       this.loading=true;
                       this.$message.error("课时添加失败! ! !");
                       this.loading=false;
                   });
           }
          },
         //显示章节状态
         showSectionStatus(data) {
            this.selSectionTemp.course_section_status=data.course_section_status
            this.showStatusForm = true;
         },

            //跳转到错误页面
            redirectToError() {
                this.$router.replace({ path: "/not-found" });
            }
        }
    };
</script>

<style lang="scss">
    .course-tasks {
        .header {
            display: flex;
            justify-content: space-between;
            align-items: center;
        }

        .el-tree {
            margin-top: 20px;
        }

        .el-tree,
        .el-tree__empty-block {
            min-height: 200px;
        }

        .el-tree-node__content {
            height: auto;
        }

        .inner {
            display: flex;
            flex: 1 0 0;
            align-items: center;
            padding: 10px;
            border-bottom: 1px solid rgba(0, 0, 0, 0.05);
        }

        .actions {
            margin-left: auto;
        }
    }
</style>
