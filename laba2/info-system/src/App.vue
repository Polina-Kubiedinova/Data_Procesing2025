<template>
  <div v-if = "cos">
  <h2>{{cos.name}}</h2>
  <img :src= "cos.imageUrl" alt="Cream image" style="max-width: 300px;"/>
  <p>{{cos.brand}}</p>
  <p>Ціна: {{cos.price}} грн</p>
  <p>Склад:{{cos.composition}}</p>
  </div>
</template>

<script setup>
import{ref, onMounted}from 'vue';
//import creamImage from './assets/images/cream.jpg';
const cos = ref(null);
onMounted(async () => {
const response = await fetch('/cos');
cos.value = await response.json();
//cos.value.imageUrl = creamImage;
console.log('Data from backend:', cos.value);

});
</script>
