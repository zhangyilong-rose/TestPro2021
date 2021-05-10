<template>
    <div class="header">
        <div class="collapse-btn" @click="collapseChange">
            <i class="el-icon-arrow-left">点此隐藏</i>
        </div>
        <div class="logo" style="font-size: 1px;">
            By小生我怕怕
        </div>
        <div class="header-right">
            <div class="btn-fullscreen" @click="handleFullScreen">
                <el-tooltip :content="fullscreen?'取消全屏':'全屏'" placement="bottom">
                    <i class="el-icon-full-screen"></i>
                </el-tooltip>

            </div>
        </div>
    </div>
</template>

<script>
    import bus from "../assets/js/bus";
    export default {
        data() {
            return {
                collapse: false,
                fullscreen: false
            }
        },
        methods: {
            //侧边栏折叠
            collapseChange() {
                this.collapse = !this.collapse;
                bus.$emit('collapse', this.collapse);
            },
            //全屏事件
            handleFullScreen() {
                if (this.fullscreen) {
                    if (document.exitFullscreen) {
                        document.exitFullscreen();
                    } else if (document.webkitCancelFullScreen) {// Chrome
                        document.webkitCancelFullScreen();
                    } else if (document.mozCancelFullScreen) {//firefox
                        document.mozCancelFullScreen();
                    } else if (document.msExitFullScreen) {
                        document.msExitFullScreen();
                    }
                } else {
                    let element = document.documentElement;
                    if (element.requestFullscreen) {
                        element.requestFullscreen();
                    } else if (element.webkitRequestFullScreen) {
                        element.webkitRequestFullScreen();
                    } else if (element.mozRequestFullScreen) {
                        element.mozRequestFullScreen();
                    } else if (element.msRequestFullScreen) {
                        element.msRequestFullScreen();
                    }
                }
                this.fullscreen = !this.fullscreen;
            }
        }

    }
</script>

<style>
    .header {
        position: relative;
        background-color: #253041;
        box-sizing: border-box;
        width: 100%;
        height: 70px;
        font-size: 22px;
        color: #ffffff;
    }

    .collapse-btn {
        float: left;
        padding: 0 21px;
        cursor: pointer;
        line-height: 70px;
    }

    .header .logo {
        float: left;
        line-height: 70px;
    }

    .header-right {
        float: right;
        padding-right: 50px;
        display: flex;
        height: 70px;
        align-items: center;
    }

    .btn-fullscreen {
        margin-right: 5px;
        font-size: 24px;

    }
</style>