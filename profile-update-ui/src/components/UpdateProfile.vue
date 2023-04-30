<script>
import { useVuelidate } from '@vuelidate/core'
import { maxLength } from '@vuelidate/validators'

export default {
  setup() {
    return { v$: useVuelidate() }
  },
  data() {
    return {
      inputs: {
        file: '',
        description: ''
      }
    }
  },

  validations() {
    return {
      inputs: {
        file: {
          maxValue: (file) => {
            return file.size > 512 ? false : true
          }
        },

        description: {
          maxLength: maxLength(1000)
        }
      }
    }
  },

  methods: {
    async updateProfile(event) {
      const valid = await this.v$.$validate()
      if (valid) {
        console.log('clicked')

        const formData = new FormData()
        // formData.append('avatar', this.inputs.file)
        formData.append('description', this.inputs.description)
        // console.log(formData.avatar.size)
        console.log(formData.description)
      }
    },

    async uploadFile(event) {
      this.inputs.file = event.target.files[0]
      console.log(this.inputs.file)
    }
  }
}
</script>

<template>
  <main id="main" class="container-xl my-5 pt-2">
    <h1>My Profile</h1>
    <div class="row row-cols-1 row-cols-md-2 mb-1 mt-4">
      <div class="col-md-4 mb-5">
        <img
          src="/images/1d53713d-6b20-4398-a1a8-a598ce19b1bdboule_noire.jpg"
          class="rounded img-fluid"
        />
      </div>
      <div class="col-md-4"></div>
    </div>

    <div class="mb-3 mt-4">
      <form @submit.prevent="updateProfile">
        <div>
          <input
            @change="uploadFile"
            name="formFile"
            id="formFile"
            class="form-control"
            type="file"
            accept="image/png,image/gif,image/jpeg"
          />
          <div class="form-text text-danger" v-if="v$.inputs.file.$error">
            Image size must be less than 500ko
          </div>
          <div class="form-text mb-3" v-else>Photo, avatar or any image.</div>
        </div>
        <label for="description" class="form-label">Description</label>
        <textarea
          v-model.trim="v$.inputs.description.$model"
          name="description"
          id="description"
          class="form-control"
          rows="10"
        ></textarea>
        <div class="input-errors" v-for="(error, index) of v$.inputs.description.$errors">
          <div class="form-text text-danger">Text with a maximum of 1000 chars .</div>
        </div>
        <div class="d-grid gap-2 d-md-flex justify-content-md-end mt-4 buttons-w">
          <button class="btn btn-primary me-md-2" type="submit" :disabled="v$.invalid">
            Update
          </button>
        </div>
      </form>
    </div>
  </main>
</template>
