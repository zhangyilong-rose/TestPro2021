<template>
    <div class="main_div">
        <el-container style="height: 100%; border: 1px solid #eee">
            <el-aside width="200px" style="background-color: rgb(238, 241, 246)">
                <el-menu :default-openeds="['1']">
                    <el-submenu index="1">
                        <template slot="title"><i class="el-icon-message"></i>导航一</template>
                        <el-menu-item index="1-1">
                            <router-link to="/test1">单个接口测试</router-link>
                        </el-menu-item>
                        <el-menu-item index="1-2">
                            <router-link to="/test2">批量接口测试</router-link>
                        </el-menu-item>
                    </el-submenu>
                    <el-submenu index="2">
                        <template slot="title"><i class="el-icon-message"></i>导航二</template>
                        <el-menu-item index="1-1">选项1</el-menu-item>
                        <el-menu-item index="1-2">选项2</el-menu-item>
                        <el-menu-item index="1-3">选项3</el-menu-item>
                        <el-menu-item index="1-3">选项4</el-menu-item>
                    </el-submenu>
                </el-menu>
            </el-aside>

            <el-container>
                <el-header style="text-align: right; font-size: 12px">
                    <el-dropdown>
                        <i class="el-icon-setting" style="margin-right: 15px"></i>
                        <el-dropdown-menu slot="dropdown">
                            <el-dropdown-item>查看用户信息</el-dropdown-item>
                            <el-dropdown-item>退出登录</el-dropdown-item>
                        </el-dropdown-menu>
                    </el-dropdown>
                    <span>凉城以北</span>
                </el-header>

                <el-main>
                    <router-view/>
                </el-main>
            </el-container>
        </el-container>
    </div>
</template>

<script>

    export default {
        name: 'Main'
    }
</script>

<style scoped>
    .el-header {
        background-color: #949494f8;
        color: rgb(0, 0, 0);
        line-height: 60px;
    }

    .el-aside {
        color: rgb(211, 0, 253);
    }
    .main_div{
        width: 100%;
        height: 100%;
    }
</style>