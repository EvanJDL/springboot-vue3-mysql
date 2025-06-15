<script setup>
  import { ref,onMounted } from 'vue'
  import Article from './Article.vue'
  const msg = ref('上海');
  const count = ref(0);
  function increment(){
    count.value++;
  }

  onMounted(()=>{
    console.log("success");
  });

  
</script>

<template>
  <h1>{{ msg }}</h1>
  <br>
  <button @click="increment">{{count}}</button>
  <Article/>
</template>

<style>
h1{color: red}
</style>
