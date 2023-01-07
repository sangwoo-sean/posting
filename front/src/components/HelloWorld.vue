<template>
  <div class="hello">
    <h1>{{ msg }}</h1>
      <h2>{{content}}</h2>
  </div>
</template>

<script>
import axios from 'axios';

export default {
    name: 'HelloWorld',
    props: {
        msg: String
    },
    data() {
        return {
            content: ""
        }
    },
    created() {
        axios.get(process.env.API_URL + "/user")
            .then(res => {
                this.content = res;
            })
            .catch(console.error);
    }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h3 {
  margin: 40px 0 0;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
</style>
