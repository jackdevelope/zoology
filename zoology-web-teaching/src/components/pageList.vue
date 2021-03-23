<template>
 <div class="block">
   <el-pagination
           @size-change="handleSizeChange",
           @current-change="handleCurrentChange",
           :current-page.sync="currentPage",
           :page-sizes="[10,20,30,40]"
           :page-size="10"
           layout="sizes,prev,pager,next"
           :total="1000"
   >
   </el-pagination>
 </div>
</template>

<script>
    export default {
        name: "pageList",
        data() {
          return {
              currentPage
          };
        },
        methods: {
            handleSizeChange(val) {
              console.log("每页:"+val+"条")
            },
            handleSizeChange(val) {
              console.log("当前页:"+val+"条")
            }
        }
    }
</script>

<style scoped>

</style>
