import config from '../config';

const urlCategories = `${config.urlBackEnd}/videos`;

function create(objetoDoVideo) {
  return fetch(`${urlCategories}?_embed=videos`, {
    method: 'POST',
    headers: {
      'Content-type': 'application/json',
    },
    body: JSON.stringify(objetoDoVideo),
  })
    .then(async (response) => {
      if (response.ok) {
        const resp = await response.json();
        return resp;
      }
      throw new Error('Não foi possível pegar os dados');
    });
}

export default {
  create,
};
