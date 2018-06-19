package com.thanh.twitsplit.presentation.view.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.thanh.twitsplit.presentation.R;
import com.thanh.twitsplit.presentation.model.TwitMessageModel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TwitAdapter extends RecyclerView.Adapter<TwitAdapter.UserViewHolder> {

    private List<TwitMessageModel> messageModels = new ArrayList<>();
    private final LayoutInflater layoutInflater;
    private Context context;

    public TwitAdapter(@NonNull Context context, List<TwitMessageModel> models) {
        this.layoutInflater =
                (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.context = context;
        this.messageModels = models;
    }

    @Override
    public int getItemCount() {
        return messageModels.size();
    }

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = this.layoutInflater.inflate(R.layout.message_item, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(UserViewHolder holder, final int position) {
        final TwitMessageModel item = this.messageModels.get(position);
        holder.textViewTitle.setText(item.getMessage());
        if (position == messageModels.size() - 1) {
            Animation animation = AnimationUtils.loadAnimation(context, android.R.anim.slide_in_left);
            holder.itemView.startAnimation(animation);
        }
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public void setMessageModels(Collection<TwitMessageModel> messageModels) {
        this.validateUsersCollection(messageModels);
        this.messageModels = (List<TwitMessageModel>) messageModels;
        this.notifyDataSetChanged();
    }

    private void validateUsersCollection(Collection<TwitMessageModel> usersCollection) {
        if (usersCollection == null) {
            throw new IllegalArgumentException("The list cannot be null");
        }
    }

    static class UserViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.message)
        TextView textViewTitle;

        UserViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
