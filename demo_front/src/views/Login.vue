<template>
    <div>
        <h1 class="login-title">欢迎登录</h1>

        <el-form ref="form" :model="form" :rules="rules" class="loginbox">

            <el-form-item prop="name" label="账号">
                <el-input type="text" placeholder="请输入用户名" v-model="form.name"></el-input>
            </el-form-item>
            <el-form-item prop="password" label="密码">
                <el-input type="password" placeholder="请输入密码" v-model="form.password"></el-input>
            </el-form-item>
            <el-form-item>
                <el-button type="primary" @click="submitForm('form')">登录</el-button>
            </el-form-item>
        </el-form>
    </div>
</template>

<script>
    export default {
        name: 'Login',
        data() {
            return {
                form: {
                    name: '',
                    password: ''
                },
                rules: {
                    name: [
                        { required: true, message: '用户名', trigger: 'blur' },
                    ],
                    password: [
                        { required: true, message: '请输入密码', trigger: 'blur' },
                        { min: 6, max: 12, message: '长度在 6 到 12 个字符', trigger: 'blur' }
                    ]
                },
            }
        },

        methods: {
            submitForm(formName) {
                this.$refs[formName].validate((valid) => {
                    if (valid) {
                        this.$router.push('/Info')
                    } else {
                        this.$message({  
                        message:'输入格式错误！！！',
                        type:'warning'});
                    }
                });
            }
        }
    }
</script>

<style scoped>
    .loginbox {
        width: 350px;
        margin: 150px auto;
        border: 1px solid #DCDFE6;
        padding: 20px;
        border-radius: 5px;
        box-shadow: 0 0 30px #DCDFE6;
    }

    .login-title {
        text-align: center;
    }
</style>