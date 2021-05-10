<template>
  <div>
    <el-button type="primary" @click="addAll">增加</el-button>
    <el-button type="success" @click="editAll">批量编辑</el-button>
    <el-button type="primary" plain @click="submit">提交</el-button>
    <el-button type="danger" @click="delectAll">批量删除</el-button>
    <el-button type="warning" icon="el-icon-star-off" circle @click="look">显示结果</el-button>
    <el-table :data="data" @selection-change="handleSelectionChange">
      <el-table-column type="selection"></el-table-column>


      <el-table-column label="用例名称">
        <template slot-scope="scope">
          <span v-if="scope.row.show">
            <el-input size="mini" placeholder="请输入用例名称" v-model="scope.row.request_name"></el-input>
          </span>
          <span v-else>{{scope.row.request_name}}</span>
        </template>
      </el-table-column>

      <el-table-column label="请求地址">
        <template slot-scope="scope">
          <span v-if="scope.row.show">
            <el-input size="mini" placeholder="请输入请求地址" v-model="scope.row.request_address"></el-input>
          </span>
          <span v-else>{{scope.row.request_address}}</span>
        </template>
      </el-table-column>

      <el-table-column label="请求类型">
        <template slot-scope="scope">
          <el-select v-model="scope.row.request_type" slot="prepend" placeholder="请选择请求类型">
            <el-option label="Post" value="Post"></el-option>
            <el-option label="Get" value="Get"></el-option>
          </el-select>
        </template>
      </el-table-column>

      <el-table-column label="请求体数据格式">
        <template slot-scope="scope">
          <el-select v-model="scope.row.request_format" slot="prepend" placeholder="请选择请求体数据格式">
            <el-option label="json" value="json"></el-option>
            <el-option label="form" value="form"></el-option>
          </el-select>
        </template>
      </el-table-column>

      <el-table-column label="请求体(JSON)">
        <template slot-scope="scope">
          <span v-if="scope.row.show">
            <el-input size="mini" placeholder="请输入请求体" v-model="scope.row.request_body"></el-input>
          </span>
          <span v-else>{{scope.row.request_body}}</span>
        </template>
      </el-table-column>

      <el-table-column label="操作">
        <template slot-scope="scope">
          <div>
            <el-button type="success" plain @click="edit(scope.row,scope.$index)">{{scope.row.show?'保存':"修改"}}
            </el-button>
          </div>
          <div>
            <el-button type="danger" plain @click="delect(scope.$index)">单个删除</el-button>
          </div>
          <!-- <el-button @click="cope(scope.row,scope.$index)">单个复制</el-button> -->
        </template>
      </el-table-column>
    </el-table>
    <div class="pageination">
      <el-pagination background layout="total,prev,pager,next" :current-page="currentPage" :page-size="pageSize"
        :total="tabledatas.length" @current-change="handleCurrentChange">
      </el-pagination>
    </div>

    <div>
      <el-drawer style="margin-left: 150px;" title="响应数据---" :visible.sync="drawer" :direction="direction"
        :before-close="handleClose" :size="size">
        <div v-for="(item,index) in responseData">
          {{item}}
        </div>
      </el-drawer>
    </div>

  </div>
</template>
<script>
  import axios from 'axios'
  axios.defaults.baseURL = 'http://127.0.0.1:9999'
  import Vue from 'vue'
  export default {
    data() {
      return {
        tabledatas: [],
        multipleSelection: [],
        pageSize: 5,//分页每页大小
        currentPage: 1,//当前页
        responseData: [],
        drawer: false,
        direction: 'btt',
        size: '800px',
      }
    },
    computed: {
      data() {
        //计算当前收缩结果表的数据
        return this.tabledatas.slice((this.currentPage - 1) * this.pageSize, this.currentPage * this.pageSize)
      }
    },
    created() {
      this.tabledatas = [
        {
          request_name: '接口测试用例1',
          request_address: 'https://www.baidu.com',
          request_type: 'Get',
          request_format: 'json',
          request_body: '',
        },
        {
          request_name: '接口测试用例2',
          request_address: 'http://127.0.0.1:9999/common/fgadmin/login',
          request_type: 'Post',
          request_format: 'json',
          request_body: '{ "phoneNumber":"20000000000", "password":"netease123", "phoneArea":"86" }',
        },
        {
          request_name: '接口测试用例3',
          request_address: 'http://127.0.0.1:9999/common/skuList1',
          request_type: 'Post',
          request_format: 'form',
          request_body: '{"goodsId":1}',
        },
        {
          request_name: '接口测试用例4',
          request_address: 'http://127.0.0.1:9999/common/skuList',
          request_type: 'Get',
          request_format: 'form',
          request_body: '{"goodsId":1}',
        },
        {
          request_name: '接口测试用例5',
          request_address: 'http://127.0.0.1:9999/login',
          request_type: 'Get',
          request_format: 'json',
          request_body: '',
        },
      ]
      this.tabledatas.map(i => {
        i.show = false
        return i
      })
    },
    methods: {
      handleClose(done) {//抽屉
        this.$confirm('确认关闭？')
          .then(_ => {
            done();
          })
          .catch(_ => { });
      },
      look() {//显示结果
        this.drawer = true;
        for (var index = 0; index < this.responseData.length; index++) {
          console.log(this.responseData[index])
        }
      },
      handleCurrentChange(val) {
        this.currentPage = val
      },
      edit(row, index) {
        row.show = row.show ? false : true
        Vue.set(this.tabledatas, index, row)
        // 修改后保存
      },
      editAll() {
        this.tabledatas.map((i, index) => {
          i.show = true
          Vue.set(this.tabledatas, index, i)
        })
      },
      sleep(numberMillis) {
        var now = new Date();
        var exitTime = now.getTime() + numberMillis;
        while (true) {
          now = new Date();
          if (now.getTime() > exitTime)
            return;
        }
      },
      submit() {
        //前后端交互按钮-----
        //tabledatas 为[{4}{4}{}{}{}{}{}........]的json数组
        this.tabledatas.map((i, index) => {
          i.show = false
          Vue.set(this.tabledatas, index, i)
        });
        console.log(this.tabledatas)
        var arr = new Array()
        for (var index = 0; index < this.tabledatas.length; index++) {
          axios.post('/test1', this.tabledatas[index])
            .then(res => {
              arr.push(res.data);
              console.log(res.data);
            })
            .catch(function (error) {
              console.log(error);
            });
        };
        this.responseData = arr
      },
      // 单个复制
      // cope(val, index) {
      //   this.tabledatas.splice(index, 0, JSON.parse(JSON.stringify(val)))
      // },
      // 单个删除
      delect(index) {
        this.tabledatas.splice(index, 1)
      },
      //批量新增
      addAll() {
        if (this.multipleSelection.length == 0) {
          let list = {
            request_name: '',
            request_address: '',
            request_type: '',
            request_format: '',
            request_body: '',
          }
          this.tabledatas.push(list)
        } else {
          this.multipleSelection.forEach((val, index) => {
            this.tabledatas.splice(index, 0, JSON.parse(JSON.stringify(val)))
          });
        }
      },
      //批量删除
      delectAll() {
        for (let i = 0; i < this.tabledatas.length; i++) {
          const element = this.tabledatas[i];
          element.id = i
        }
        if (this.multipleSelection.length == 0) this.$message.error('请先至少选择一项')
        this.multipleSelection.forEach(element => {
          this.tabledatas.forEach((e, i) => {
            if (element.id == e.id) {
              this.tabledatas.splice(i, 1)
            }
          });
        });
      },
      //选
      handleSelectionChange(val) {
        this.multipleSelection = val;
      }
    },
  }
</script>

<style>
  .pageination {
    display: flex;
    justify-content: center;
  }

  ::v-deep.el-drawer__wrapper {
    z-index: -3000 !important;
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
    padding: 0;
    width: auto;
    height: 30px;
    margin: 12px;
    font-size: 16px;
    color: #ffffff;
    background: rgba(96, 218, 223, 0.5);
  }

  .el-drawer__body {

    overflow: auto;
    margin: 0px 10px 10px 10px;
    background: rgba(19, 32, 42, 0.5);
    color: #ffffff;
    padding: 0;
    width: auto;
    height: 1500px;
    position: relative;
  }
</style>