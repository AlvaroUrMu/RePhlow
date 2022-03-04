package org.ivz.ad.aurbano.rephlow.view.adapter.viewholder;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.RecyclerView;

import org.ivz.ad.aurbano.rephlow.R;
import org.ivz.ad.aurbano.rephlow.model.entity.Flora;
import org.ivz.ad.aurbano.rephlow.view.AddImagenActivity;
import org.ivz.ad.aurbano.rephlow.view.EditActivity;
import org.ivz.ad.aurbano.rephlow.viewmodel.DeleteFloraViewModel;
import org.ivz.ad.aurbano.rephlow.viewmodel.EditFloraViewModel;

public class FloraViewHolder extends RecyclerView.ViewHolder {
    public Flora flora;
    public CardView cvFlora;
    public ImageView ivImage;
    public TextView tvNombre, tvFamilia, tvIdent, tvAltitud, tvHabitat, tvFito, tvBiotipo, tvBiorep,
            tvFlor, tvFruct, tvExpsex, tvPolin, tvDisp, tvNumcrom, tvRepasex, tvDist, tvBiologia,
            tvDemo, tvAmen, tvMedprop;
    public ImageButton ibExpand, btEditInfo, btEditImage;
    public LinearLayout dataLayout;

    public FloraViewHolder(@NonNull View itemView) {
        super(itemView);

        init();

        btEditInfo.setOnClickListener(v -> {
            Intent intent = new Intent(itemView.getContext(), EditActivity.class);
            intent.putExtra("flora", flora);
            itemView.getContext().startActivity(intent);
        });

        btEditImage.setOnClickListener(v -> {
            Intent intent = new Intent(itemView.getContext(), AddImagenActivity.class);
            intent.putExtra("idflora", flora.getId());
            itemView.getContext().startActivity(intent);
        });

        /*btDelete.setOnClickListener(v -> {
            DeleteFloraViewModel dvm = new ViewModelProvider(this).get(DeleteFloraViewModel.class);
            dvm.deleteFlora(flora.getId());
        });*/
    }

    public void init() {
        cvFlora = itemView.findViewById(R.id.cvFlora);
        ivImage = itemView.findViewById(R.id.ivImage);
        tvNombre = itemView.findViewById(R.id.tvNombre);
        tvFamilia = itemView.findViewById(R.id.tvFamilia);
        tvIdent = itemView.findViewById(R.id.tvIdent);
        tvAltitud = itemView.findViewById(R.id.tvAltitud);
        tvHabitat = itemView.findViewById(R.id.tvHabitat);
        tvFito = itemView.findViewById(R.id.tvFito);
        tvBiotipo = itemView.findViewById(R.id.tvBiotipo);
        tvBiorep = itemView.findViewById(R.id.tvBiorep);
        tvFlor = itemView.findViewById(R.id.tvFlor);
        tvFruct = itemView.findViewById(R.id.tvFruct);
        tvExpsex = itemView.findViewById(R.id.tvExpsex);
        tvPolin = itemView.findViewById(R.id.tvPolin);
        tvDisp = itemView.findViewById(R.id.tvDisp);
        tvNumcrom = itemView.findViewById(R.id.tvNumcrom);
        tvRepasex = itemView.findViewById(R.id.tvRepAsex);
        tvDist = itemView.findViewById(R.id.tvDist);
        tvBiologia = itemView.findViewById(R.id.tvBiologia);
        tvDemo = itemView.findViewById(R.id.tvDemo);
        tvAmen = itemView.findViewById(R.id.tvAmen);
        tvMedprop = itemView.findViewById(R.id.tvMedprop);
        ibExpand = itemView.findViewById(R.id.ibExpand);
        dataLayout = itemView.findViewById(R.id.dataLayout);
        btEditInfo = itemView.findViewById(R.id.btEditInfo);
        btEditImage = itemView.findViewById(R.id.btEditImage);
    }
}
