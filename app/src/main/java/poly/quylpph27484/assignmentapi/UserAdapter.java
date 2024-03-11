package poly.quylpph27484.assignmentapi;
import android.annotation.SuppressLint;
import android.media.Image;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;
public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {
    private List<Albums> userList;
    public UserAdapter(List<Albums> userList) {
        this.userList = userList;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder,  int position) {
        Albums user = userList.get(holder.getAdapterPosition());
        holder.bind(user);

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                if (holder.getAdapterPosition() != RecyclerView.NO_POSITION) {
                    userList.remove(holder.getAdapterPosition());
                    notifyItemRemoved(holder.getAdapterPosition());
                    System.out.println(userList);
                    System.out.println(holder.getAdapterPosition());
                }
               return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public static class UserViewHolder extends RecyclerView.ViewHolder {
        private TextView tvUserId;
        private TextView tvId;
        private TextView tvTitle;
        private ImageView star;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            tvUserId = itemView.findViewById(R.id.userId);
            tvId = itemView.findViewById(R.id.id);
            tvTitle = itemView.findViewById(R.id.title);
            star = itemView.findViewById(R.id.star);

        }

        public void bind(Albums albums) {
            tvUserId.setText(String.valueOf(albums.getUserId()));
            tvId.setText(String.valueOf(albums.getId()));
            tvTitle.setText(albums.getTitle());

            if (albums.getId() % 3 == 0) {
                star.setVisibility(View.VISIBLE);
            } else {
                star.setVisibility(View.GONE);
            }
        }
    }
}
