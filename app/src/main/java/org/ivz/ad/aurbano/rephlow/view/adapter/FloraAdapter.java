package org.ivz.ad.aurbano.rephlow.view.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import org.ivz.ad.aurbano.rephlow.R;
import org.ivz.ad.aurbano.rephlow.model.entity.Flora;
import org.ivz.ad.aurbano.rephlow.view.EditActivity;
import org.ivz.ad.aurbano.rephlow.view.adapter.viewholder.FloraViewHolder;

import java.util.List;

public class FloraAdapter extends RecyclerView.Adapter<FloraViewHolder>{
    private List<Flora> floraList;
    private Context context;
    private AlertDialog.Builder alertDialog;

    public FloraAdapter(Context context){
        this.context = context;
    }

    @NonNull
    @Override
    public FloraViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_flora, parent, false);
        return new FloraViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FloraViewHolder holder, int position) {

        alertDialog = new AlertDialog.Builder(context);

        Flora flora = floraList.get(position);
        holder.flora = flora;

        String urlImage = "https://informatica.ieszaidinvergeles.org:10018/ad/felixRDLFApp/public/api/imagen/" + flora.getId() + "/flora";
        String defaultImage = "https://informatica.ieszaidinvergeles.org:10018/ad/felixRDLFApp/public/storage/images/noimageflora.jpeg";

        Glide.with(context).load(urlImage).into(holder.ivImage);

        holder.tvNombre.setText(flora.getNombre());
        holder.tvFamilia.setText(flora.getFamilia());
        holder.tvIdent.setText(flora.getIdentificacion());
        holder.tvAltitud.setText(flora.getAltitud());
        holder.tvHabitat.setText(flora.getHabitat());
        holder.tvFito.setText(flora.getFitosociologia());
        holder.tvBiotipo.setText(flora.getBiotipo());
        holder.tvBiorep.setText(flora.getBiologia_reproductiva());
        holder.tvFlor.setText(flora.getFloracion());
        holder.tvFruct.setText(flora.getFructificacion());
        holder.tvExpsex.setText(flora.getExpresion_sexual());
        holder.tvPolin.setText(flora.getPolinizacion());
        holder.tvDisp.setText(flora.getDispersion());
        holder.tvNumcrom.setText(flora.getNumero_cromosomatico());
        holder.tvRepasex.setText(flora.getReproduccion_asexual());
        holder.tvDist.setText(flora.getDistribucion());
        holder.tvBiologia.setText(flora.getBiologia());
        holder.tvDemo.setText(flora.getDemografia());
        holder.tvAmen.setText(flora.getAmenazas());
        holder.tvMedprop.setText(flora.getMedidas_propuestas());

        if(holder.tvFamilia.getText().length() == 0) {
            holder.tvFamilia.setText("Sin información");
        }

        if(holder.tvIdent.getText().length() == 0) {
            holder.tvIdent.setText("Sin información");
        }

        if(holder.tvAltitud.getText().length() == 0) {
            holder.tvAltitud.setText("Sin información");
        }

        if(holder.tvHabitat.getText().length() == 0) {
            holder.tvHabitat.setText("Sin información");
        }

        if(holder.tvFito.getText().length() == 0) {
            holder.tvFito.setText("Sin información");
        }

        if(holder.tvBiotipo.getText().length() == 0) {
            holder.tvBiotipo.setText("Sin información");
        }

        if(holder.tvBiorep.getText().length() == 0) {
            holder.tvBiorep.setText("Sin información");
        }

        if(holder.tvFlor.getText().length() == 0) {
            holder.tvFlor.setText("Sin información");
        }

        if(holder.tvFruct.getText().length() == 0) {
            holder.tvFruct.setText("Sin información");
        }

        if(holder.tvExpsex.getText().length() == 0) {
            holder.tvExpsex.setText("Sin información");
        }

        if(holder.tvPolin.getText().length() == 0) {
            holder.tvPolin.setText("Sin información");
        }

        if(holder.tvDisp.getText().length() == 0) {
            holder.tvDisp.setText("Sin información");
        }

        if(holder.tvNumcrom.getText().length() == 0) {
            holder.tvNumcrom.setText("Sin información");
        }

        if(holder.tvRepasex.getText().length() == 0) {
            holder.tvRepasex.setText("Sin información");
        }

        if(holder.tvDist.getText().length() == 0) {
            holder.tvDist.setText("Sin información");
        }

        if(holder.tvBiologia.getText().length() == 0) {
            holder.tvBiologia.setText("Sin información");
        }

        if(holder.tvDemo.getText().length() == 0) {
            holder.tvDemo.setText("Sin información");
        }

        if(holder.tvAmen.getText().length() == 0) {
            holder.tvAmen.setText("Sin información");
        }

        if(holder.tvMedprop.getText().length() == 0) {
            holder.tvMedprop.setText("Sin información");
        }

        holder.ibExpand.setOnClickListener(v -> {
            if (holder.dataLayout.getVisibility() == View.GONE) {
                TransitionManager.beginDelayedTransition(holder.cvFlora, new AutoTransition());
                holder.dataLayout.setVisibility(View.VISIBLE);
                holder.ibExpand.setImageResource(R.drawable.ic_baseline_keyboard_arrow_up_24);
            } else {
                TransitionManager.beginDelayedTransition(holder.cvFlora, new AutoTransition());
                holder.dataLayout.setVisibility(View.GONE);
                holder.ibExpand.setImageResource(R.drawable.ic_baseline_keyboard_arrow_down_24);
            }
        });

        /* holder.tvId.setText(String.valueOf(flora.getId()));

        holder.ivImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.setTitle(holder.tvNombre.getText()).setPositiveButton("edit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        context.startActivity(new Intent(context, EditActivity.class));
                    }
                }).setNegativeButton("cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                }).show();
            }
        });*/
    }

    @Override
    public int getItemCount() {
        if(floraList == null) {
            return 0;
        }
        return floraList.size();
    }

    public void setFloraList(List<Flora> floraList) {
        this.floraList = floraList;
        notifyDataSetChanged();
    }
}
