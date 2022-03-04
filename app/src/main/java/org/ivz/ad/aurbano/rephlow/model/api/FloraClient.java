package org.ivz.ad.aurbano.rephlow.model.api;

import org.ivz.ad.aurbano.rephlow.model.entity.CreateResponse;
import org.ivz.ad.aurbano.rephlow.model.entity.Flora;
import org.ivz.ad.aurbano.rephlow.model.entity.Imagen;
import org.ivz.ad.aurbano.rephlow.model.entity.RowsResponse;

import java.util.ArrayList;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.Path;

public interface FloraClient {
    @DELETE("api/flora/{id}")
    Call<RowsResponse> deleteFlora(@Path("id") long id);

    @GET("api/flora/{id}")
    Call<Flora> getFlora(@Path("id") long id);

    @GET("api/flora")
    Call<ArrayList<Flora>> getFlora();

    @POST("api/flora")
    Call<CreateResponse> createFlora(@Body Flora flora);

    @PUT("api/flora/{id}")
    Call<RowsResponse> editFlora(@Path("id") long id, @Body Flora flora);

    @Multipart
    @POST("api/imagen/subir")
    Call<Long> subirImagen(@Part MultipartBody.Part file, @Part("idflora") long idFlora, @Part("descripcion") String descripcion);

    @GET("api/imagen/{imagen}") // Obtiene todas las imagenes de la clase Imagen asignada
    Call<ArrayList<Imagen>> getAllImages(@Path("id") long id, @Body Imagen imagen);

    @GET("api/flora/{flora}/imagen") // Obtiene una lista de objetos Imagen
    Call<ArrayList<Imagen>> getImages();

    @GET("api/imagen/{flora}/flora") // Obtiene una imagen de la clase Imagen
    Call<Imagen> getImage(@Path("id") long id, @Body Imagen imagen);
}
