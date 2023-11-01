import { useState } from 'react';

function useForm(valoresIniciais) {
  const [values, setvalues] = useState(valoresIniciais);
  function setValoresIniciais(chave, valor) {
    setvalues({
      ...values,
      [chave]: valor,
    });
  }

  function handleChange(info) {
    setValoresIniciais(
      info.target.getAttribute('name'),
      info.target.value,
    );
  }

  function clearForm() {
    setvalues(valoresIniciais);
  }
  return { handleChange, values, clearForm };
}

export default useForm;
