import React from "react";

 const ListPedido = () => {
  return (
    <div class="modal fade" data-toggle="modal" id="visualizar" role="dialog">
      <div class="modal-dialog modal-dialog-centered" role="document">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title" id="demo"></h5>
            <button
              type="button"
              class="close"
              data-dismiss="modal"
              aria-label="Close"
            >
              <span aria-hidden="true">&times;</span>
            </button>
          </div>
          <div class="modal-body">
            <form>
              <div class="form-group">
                <label>
                  <h5>Gênero</h5>
                </label>
                <div id="demo1"></div>
              </div>
              <div class="form-group">
                <label>
                  <h5>Temporadas</h5>
                </label>
                <div id="demo2"></div>
              </div>
              <div class="form-group">
                <label>
                  <h5>Personagem Principal</h5>
                </label>
                <div id="demo3"></div>
              </div>
              <div class="form-group">
                <label>
                  <h5>Público</h5>
                </label>
                <div id="demo4"></div>
              </div>
              <div class="form-group">
                <label>
                  <h5>Sinopse</h5>
                </label>
                <div id="demo6"></div>
              </div>
            </form>
          </div>
        </div>
      </div>
    </div>
  );
};
export default ListPedido
