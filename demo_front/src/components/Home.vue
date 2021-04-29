<template>
  <div>
    <The-header></The-header>
    <the-aside></the-aside>
    <div class="content-box" :class="{'content-collapse':collapse}">
      <router-view></router-view>
    </div>
  </div>
</template>

<script>
  import TheHeader from './TheHeader';
  import TheAside from './TheAside';
  import bus from '../assets/js/bus';

  export default {
    components: {
      TheAside,
      TheHeader
    },
    data() {
      return {
        collapse: false
      }
    },
    created() {
      bus.$on('collapse', msg => {
        this.collapse = msg
      })
    }
  }
</script>

<style>

</style>