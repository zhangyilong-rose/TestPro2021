<template>
  <div>
    <el-button type="primary" @click = "get_res">主要按钮</el-button>
    {{response}}

  </div>
</template>


<script>

  import axios from 'axios'
  import Vue from 'vue'

  export default{
    data(){
      return{
        response:[],
      }
    },

    methods:{
      get_res(){
        axios.get('http://127.0.0.1:9999/response')
        .then(res=>{
          this.response = res;
        })
        
      }
    }
  }

</script>