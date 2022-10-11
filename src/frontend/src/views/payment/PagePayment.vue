<template>
  <div>
    <h2>IAMPORT 결제 데모</h2>
    <li><button id="iamportPayment" type="button">결제테스트</button></li>
    <p>aa</p>
  </div>
</template>

<script>
import { iamport } from '../../assets/iamport.2'

export default {
  name: "PagePayment",
  created() {
    let jqueryScript = document.createElement('script')
    jqueryScript.setAttribute('src', 'https://code.jquery.com/jquery-1.12.4.min.js')
    jqueryScript.setAttribute('type', 'text/javascript')
    document.head.appendChild(jqueryScript)

    let iamportScript = document.createElement('script')
    iamportScript.setAttribute('src', 'https://cdn.iamport.kr/js/iamport.payment-1.2.0.js')
    iamportScript.setAttribute('type', 'text/javascript')
    document.head.appendChild(iamportScript)

  },
  mounted() {


    iamport.init();
  },

}
</script>

<style scoped>

</style>