import React from "react";

const FormCadastro = () => {
    return (
      <div class="card">
        <div class="card-header">
          <h4>Formulário (Alterar/Excluir)</h4>
        </div>
        <div class="card-body">
          <form>
            <div class="form-row">
              <div class="form-group col-md-6">
                <label for="inputEmail4"></label>
                <input
                  type="text"
                  class="form-control"
                  id=""
                  placeholder="Nome do Anime"
                />
              </div>
              <div class="form-group col-md-6">
                <label>Personagem Principal</label>
                <input
                  id="persprincipal"
                  type="text"
                  class="form-control"
                  idAdress="inputAddress2"
                  placeholder="Personagem principal do anime"
                />
              </div>
            </div>
            <div class="form-row">
              <div class="form-group col-md-6">
                <label>Gênero</label>
                <select id="genero" class="form-control">
                  <option selected>Escolha</option>
                  <option value="Ação">Ação</option>
                  <option value="Aventura">Aventura</option>
                  <option value="Faroeste">Faroeste</option>
                  <option value="Romance">Romance</option>
                  <option value="Drama">Drama</option>
                  <option value="Comédia">Comédia</option>
                  <option value="Paródia">Paródia</option>
                  <option value="Fantasia">Fantasia</option>
                  <option value="Horror">Horror</option>
                  <option value="Investigação">Policial/Investigação</option>
                  <option value="Jogos/Esportes">Jogos/Esportes</option>
                  <option value="Artes Marciais">Artes Marciais</option>
                </select>
              </div>
              <div class="form-group col-md-6">
                <label>Público</label>
                <select id="publico" class="form-control">
                  <option selected>Escolha</option>
                  <option value="Shõjo">Shōjo</option>
                  <option value="Josei">Josei</option>
                  <option value="Shounen">Shounen</option>
                  <option value="Seinen">Seinen</option>
                  <option value="Komodo">Kodomo</option>
                </select>
              </div>
            </div>
            <div class="form-row">
              <div class="form-group col-md-6">
                <label for="inputCity">Temporadas</label>
                <input
                  id="temporada"
                  type="number"
                  min="0"
                  max="30"
                  class="form-control"
                />
              </div>
            </div>
            <div class="form-row">
              <div class="form-group col-md-6">
                <label>Sinopse</label>
                <textarea class="form-control" id="sinopse" rows="3"></textarea>
              </div>
            </div>
          </form>
        </div>
        <div class="card-footer text-muted">
          <a href="index.html" class="btn btn-danger btn-lg active" role="button">
            Cancelar
          </a>
          <button
            class="btn btn-success btn-lg active"
            role="button"
            onclick="salvar()"
          >
            Salvar
          </button>
          <a
            href="index.html"
            class="btn btn-primary btn-lg active"
            role="button"
          >
            Voltar a lista
          </a>
        </div>
      </div>
    );
  };
  
  export default FormCadastro;