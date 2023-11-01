import config from '../config';

const urlCategories = `${config.urlBackEnd}/categorias`;

function getAllWithVideos() {
  return fetch(`${urlCategories}?_embed=videos`)
    .then(async (response) => {
      if (response.ok) {
        const resp = await response.json();
        return resp;
      }
      throw new Error('Não foi possível pegar os dados');
    });
}
function getAll() {
  return fetch(urlCategories)
    .then(async (response) => {
      if (response.ok) {
        const resp = await response.json();
        return resp;
      }
      throw new Error('Não foi possível pegar os dados');
    });
}

export default {
  getAllWithVideos,
  getAll,
};
