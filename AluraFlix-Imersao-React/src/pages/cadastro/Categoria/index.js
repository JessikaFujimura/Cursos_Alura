import React, { useState, useEffect } from 'react';
import { Link } from 'react-router-dom';
import PageDefault from '../../../components/PageDefault';
import FormField from '../../../components/FormField';
import Button from '../../../components/Button';
import useForm from '../../../hooks/useForm';

function CadastroCategoria() {
  useEffect(() => {
    const Url = window.location.hostname.includes('localhost')
      ? 'http://localhost:8080/categorias'
      : 'https://aluraflix-jmf.herokuapp.com/categorias';
    fetch(Url)
      .then(async (response) => {
        const resp = await response.json();
        return resp;
      })
      .then((data) => setCategorias([...data]));
  }, []);

  const valoresIniciais = {
    nome: '',
    descricao: '',
    cor: '',
  };

  const [categorias, setCategorias] = useState([]);

  const { handleChange, values, clearForm } = useForm(valoresIniciais);

  function handleSubmit(e) {
    e.preventDefault();
    setCategorias([...categorias, values]);
    clearForm();
  }

  return (
    <>
      <PageDefault>
        <h1>
          Cadastro categoria:
          {
          values.nome
          }
        </h1>
        <form onSubmit={(e) => handleSubmit(e)}>

          <FormField
            label="Nome da categoria"
            type="text"
            name="nome"
            value={values.nome}
            onChange={handleChange}
          />

          <FormField
            label="Descrição"
            type="textarea"
            name="descricao"
            value={values.descricao}
            onChange={handleChange}
          />

          <FormField
            label="Cor da categoria"
            type="color"
            name="cor"
            value={values.cor}
            onChange={handleChange}
          />

          <Button>
            Cadastrar
          </Button>

        </form>

        {categorias.length === 0
          ? <p>Loading...</p>
          : (
            <table>
              <thead>
                <tr>
                  <th>
                    Nome
                  </th>
                  <th>
                    Descricao
                  </th>
                  <th>
                    Cor
                  </th>
                </tr>
              </thead>
              <tbody>
                {categorias.map((categoria, index) => (
                  <tr key={`${index} ${categoria}`}>
                    <th>{categoria.nome}</th>
                    <th>{categoria.descricao}</th>
                    <th style={{ backgroundColor: categoria.cor }}>{categoria.cor}</th>
                  </tr>
                ))}
              </tbody>
            </table>
          )}

        <Link to="/">
          Ir para home
        </Link>
      </PageDefault>
    </>
  );
}

export default CadastroCategoria;
