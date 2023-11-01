import React, { useEffect, useState } from 'react';
import { Link, useHistory } from 'react-router-dom';
import PageDefault from '../../../components/PageDefault';
import FormField from '../../../components/FormField';
import Button from '../../../components/Button';
import useForm from '../../../hooks/useForm';
import videosRepository from '../../../repositories/videos';
import categoriesRepository from '../../../repositories/categorias';

function CadastroVideo() {
  const { handleChange, values } = useForm({
    titulo: 'DevRaiz',
    url: 'https://www.youtube.com/watch?v=BBFvqb6Y43s',
    categoria: 'Front-End',
  });
  const history = useHistory();
  const [categorias, setCategorias] = useState([]);

  useEffect(() => {
    categoriesRepository.getAll()
      .then((allCategorias) => setCategorias(allCategorias));
  }, []);

  const categoryTitles = categorias.map(({ titulo }) => titulo);

  return (
    <>
      <PageDefault>
        <h1>Cadastro de vídeo</h1>
        <form onSubmit={(e) => {
          e.preventDefault();

          const categoriaEscolhida = categorias.find((categoria) => categoria.titulo === values.categoria);

          videosRepository.create({
            titulo: values.titulo,
            url: values.url,
            categoriaId: categoriaEscolhida,
          })
            .then(() => {
              console.log('cadastrado');
              history.push('/');
            });
        }}
        >
          <FormField
            label="Título do vídeo"
            type="text"
            name="titulo"
            value={values.titulo}
            onChange={handleChange}
          />

          <FormField
            label="URL"
            type="text"
            name="url"
            value={values.url}
            onChange={handleChange}
          />

          <FormField
            label="Categoria"
            type="text"
            name="categoria"
            value={values.categoria}
            onChange={handleChange}
            suggestions={categoryTitles}
          />

          <Button>
            Cadastrar
          </Button>

        </form>

        <Link to="/cadastro/categoria">
          Cadastrar de Categoria
        </Link>
      </PageDefault>
    </>
  );
}

export default CadastroVideo;
