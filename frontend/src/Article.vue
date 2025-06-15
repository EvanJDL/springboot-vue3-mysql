<script setup>
import axios from "axios";
import {ref} from "vue"
const articleList = ref([]); 
axios.get('/data/article.json').then(result=>
    {articleList.value = result.data}).catch(err=>{
    console.log(err);
    });

</script>
    
<template>
    <div>
        <div>
            Category: <input type="text"/>
            status: <input type="text"/>
            <button>search</button>
        </div>        
        <div>
            <table border="1">
                <thead>
                <tr>
                    <th>title</th>
                    <th>category</th>
                    <th>publish time</th>
                    <th>status</th>
                    <th>operation</th>
                </tr>
                </thead>
                <tbody>
                    <tr v-for=" (article, index) in articleList" :key="index">
                        <td>{{article.title}}</td>
                        <td>{{article.category}}</td>
                        <td>{{article.publishTime}}</td>
                        <td>{{article.status}}</td>
                        
                        <td>
                            <button>modify</button>
                            <button>delete</button>
                        </td>
                    </tr>
                
                </tbody>
            </table>
        </div>
    </div>
    
</template>