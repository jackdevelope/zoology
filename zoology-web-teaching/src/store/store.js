import Vue from 'vue';
import Vuex from 'vuex';

Vue.use(Vuex);
export default new Vuex.Store({

    state:{
        operNewSec:{"detail": "New Section"},
        OperNewles:{"detail": "New lesson"},
        OperEditSec:{"detail": "Edit Section"},
        OperEditles:{"detail": "Edit lesson"}
    },
    mutations:{
        // 保存当前点击的数据源
        saveCourseId(state,courseId){
            state.course_id = courseId;

        },
        // 保存当前点击的元数据
        saveCurrJobData(state,currJobData){

            state.currJobData = currJobData;

        },

        // 保存所有数据源

        saveDbSource(state,DbSource){

            state.DbSource = DbSource;

        }

    }

})




