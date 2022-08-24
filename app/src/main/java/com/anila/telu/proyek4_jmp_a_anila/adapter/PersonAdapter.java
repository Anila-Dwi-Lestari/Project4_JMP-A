package com.anila.telu.proyek4_jmp_a_anila.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.anila.telu.proyek4_jmp_a_anila.R;
import com.anila.telu.proyek4_jmp_a_anila.model.Person;
import java.util.List;

public class PersonAdapter extends ArrayAdapter<Person> {
    private List<Person> persons;
    private Context context;

    public PersonAdapter(@NonNull Context context, @NonNull List<Person> objects) {
        super(context, R.layout.list_item, objects);
        this.persons = objects;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView,
                        @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View rowView = inflater.inflate(R.layout.list_item, parent, false);

        TextView tvNama = rowView.findViewById(R.id.tv_nama);
        TextView tvAlamat = rowView.findViewById(R.id.tv_alamat);

        tvNama.setText(persons.get(position).getNama());
        tvAlamat.setText(persons.get(position).getAlamat());

        return rowView;
    }
}
