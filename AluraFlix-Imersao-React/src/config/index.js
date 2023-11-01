const urlBackEnd = window.location.hostname.includes('localhost')
  ? 'http://localhost:8080'
  : 'https://aluraflix-jmf.herokuapp.com';

export default {
  urlBackEnd,
};
