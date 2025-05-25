<template>
  <div>
<h1>Система керування</h1>
    <h3>{{isEditing ? "Редагувати крем " : "Додати новий крем"}}</h3>
    <!--<form @submit.isEditing ? updateCos() : addCos()>-->
    <form @submit.prevent="handleSubmit">
    <input v-model = "newCos.name" placeholder = "Назва" required/>
    <input v-model = "newCos.imageUrl" placeholder="Зображення" required/>
    <input v-model = "newCos.brand" placeholder="Бренд" required/>
    <input type = "number" v-model = "newCos.price" placeholder="Ціна(грн)" required/>
    <input v-model = "newCos.composition" placeholder="Склад" required/>
    <button type="submit">{{isEditing ? "Оновити" : "Додати"}}</button>
    <button type = "button" v-if="isEditing" @click = "cancelEdit">Скасувати</button>
    </form>
<h3>Перелік косметики</h3>
    <ul>
    <li v-for = "cos in cosm" :key = "cos.id">
      <h3>{{cos.name}}</h3>
      <img :src= "cos.imageUrl" alt="Cream image" style="max-width: 150px;"/>
      <p>{{cos.brand}}</p>
      <p>Ціна: {{cos.price}} грн</p>
      <p>Склад:{{cos.composition}}</p>
      <button @click = "editCos(cos)">Редагувати</button>
      <button @click = "deleteCos(cos.id)">Видалити</button>
    </li>
    </ul>
  </div>
</template>

<script setup>
import{ref, onMounted}from 'vue';
//import creamImage from './assets/images/cream.jpg';
const cosm = ref([]);
const newCos = ref({id: null, name:"", imageUrl:"", brand:"", price:"",composition:""});
const isEditing = ref(false);

const fetchCos = async () =>{
try{
const response = await fetch("/cos");
cosm.value = await response.json();
}catch(error){console.error("помилка отримання данних:",error);}
};

const addCos = async() =>{
try{
  const response = await fetch("/cos",{
  method: 'POST',
  headers:{'Content-Type': 'application/json'},
  body: JSON.stringify(newCos.value)
});
if(response.ok){
fetchCos();
resetFormForm();}
}
catch(error){console.error("Помилка  додавання:",error);}
};

const editCos = (cos) =>{
newCos.value = {...cos};
isEditing.value = true;};

const updateCos = async () =>{
try{
const response = await fetch("/cos", {
method: "PUT",
headers: {"Content-Type" : "application/json"},
body: JSON.stringify(newCos.value),
});
if(response.ok){
fetchCos();
resetForm();
}}
catch(error){console.error("Помилка оновлення:", error);}
};

const deleteCos = async (id) =>{
try{
const response = await fetch(`/cos?id=${id}`, {method: 'DELETE'});
if(response.ok) fetchCos();}
catch(error){console.error("Помилка видалення:", error);}
};

const resetForm = () => {
newCos.value = {id: null, name:"", imageUrl:"", brand:"", price:"",composition:""};
isEditing.value=false;
};

const handleSubmit = () => {
    if (isEditing.value) {
        updateCos();
    } else {
        addCos();
    }
};

const cancelEdit = () =>{resetForm();};
onMounted(fetchCos);

</script>
<style>
body{
font-family: Arial, sans-serif;
max-width: 800px;
margin: 20px auto;
}
input{
display: block;
margin: 5px 0;
padding: 8px;
width: 100%;
}
button{
margin: 5px;
padding: 8px 12px;
cursor: pointer;
}
</style>
