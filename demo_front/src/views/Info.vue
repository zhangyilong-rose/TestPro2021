<template>
  <div>
    <div style="margin-top: 15px;">
      <el-input placeholder="请求地址" v-model="formdata.request_address" class="input-with-select">
        <el-select v-model="formdata.request_type" slot="prepend" placeholder="请选择请求类型">
          <el-option label="Post" value="Post"></el-option>
          <el-option label="Get" value="Get"></el-option>
        </el-select>
        <el-button slot="append" icon="el-icon-position" @click="post">发送请求</el-button>
      </el-input>
    </div>
    <div style="margin-top: 20px; color: rgb(204, 0, 255);">选择请求体数据传输格式：</div>
    <div style="margin-top: 20px;">
      <el-radio v-model="formdata.request_format" label="form" @change="change">form形式</el-radio>
      <el-radio v-model="formdata.request_format" label="json" @change="change">json形式</el-radio>
    </div>
    <div style="margin-top: 20px;">
      <el-input type="textarea" :rows="8" placeholder=" 请输入json形式的请求体格式!" v-model="formdata.request_body">

      </el-input>

    </div>
    <div style="margin-top: 20px;">
      响应数据：
      {{ response.data }}
    </div>
    <div style="margin-left: 20px;margin-top: 50px;">
      <el-button @click="look" type="primary" style="margin-left: 16px;">
        查看详细响应结果
      </el-button>
      <div>
        <el-drawer style="margin-left: 150px;" title="响应数据---" :visible.sync="drawer" :direction="direction"
          :before-close="handleClose" :size = "size">
          <div>
            {{ response }}
          </div>
        </el-drawer>
      </div>
    </div>
  </div>
</template>

<style>
  .el-select .el-input {

    position: relative;
    width: 130px;
  }

  .input-with-select .el-input-group__prepend {
    background-color: #fff;
  }

  
   ::v-deep.el-drawer__wrapper {
      z-index: -3000!important;
    }

    .el-drawer {
      position: relative;
      left: 150px;
      top: 150px;
      padding: 0;
      width: auto;
      height: 10000px;
      background: rgba(175, 12, 175, 0.8);
      font-size: 16px;


    }

    .el-drawer__header {
      padding: 0 ;
      width: auto;
      height: 30px;
      margin: 12px;
      font-size: 16px;
      color: #ffffff;
      background: rgba(96, 218, 223, 0.5) ;
    }

    .el-drawer__body {
      
      overflow: auto;
      margin: 0px 10px 10px 10px;
      background: rgba(19, 32, 42, 0.5) ;
      color:#ffffff;
      padding: 0;
      width: auto ;
      height: 1500px;
      position: relative;
    }

</style>
<script>
  import axios from 'axios'
  axios.defaults.baseURL = 'http://127.0.0.1:9999'

  export default {
    data() {
      return {
        response: '',
        drawer: false,
        direction: 'btt',
        size : '800px',
        formdata: {
          request_address: '',
          request_type: '',
          request_format: '',
          request_body: '',
        },
      }
    },
    methods: {
      look() {//抽屉函数
        this.drawer = true;
      },
      change() {//控制台查看前后台接口数据包
        console.log(JSON.stringify(this.formdata))
      },
      handleClose(done) {//抽屉
        this.$confirm('确认关闭？')
          .then(_ => {
            done();
          })
          .catch(_ => { });
      },
      post() {//axios前后端交互post触发
        axios.post('/test', this.formdata)
          .then(res => {
            this.response = res
            console.log(res.data)
          })
          .catch(function (error) {
            console.log(error);
          });
      }
      // post() {
      //   fetch('http://127.0.0.1:9999/test', {
      //     method: 'POST',
      //     body: JSON.stringify(this.formdata),
      //     headers: new Headers({
      //       'Content-Type': 'application/json'
      //     })

      //   }).then(res => res.json())
      //     .catch(error => console.error('Error:', error))
      //     .then(response => {
      //       console.log(response);
      //       this.response = response
      //     }
      //     );
      // }

    }
  }
</script>