package groceryapp.adapters;

import android.databinding.DataBindingUtil;
import android.databinding.ObservableList;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import javax.inject.Inject;

import groceryapp.BR;
import groceryapp.R;
import groceryapp.model.ProductData.Product;
import groceryapp.util.Navigator;
import groceryapp.viewmodel.ProductVM;

/**
 * Created by ravi.sharma01 on 2/20/18.
 */

public class ProductListAdapter
		extends
			RecyclerView.Adapter<ProductListAdapter.NewsViewHolder> {

	private final Navigator navigator;
	private ObservableList<Product> data;

	@Inject
	public ProductListAdapter(Navigator navigator) {
		// setHasStableIds(true);
		this.navigator = navigator;
	}

	// @Override
	// public long getItemId(int position) {
	// return getData().get(position).getTitle().hashCode();
	// }

	public void setData(ObservableList<Product> data) {
		this.data = data;
		data.addOnListChangedCallback(itemChangedListener);
	}

	@Override
	public int getItemViewType(int position) {
		return R.layout.product_item_view;
	}

	@Override
	public NewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		ViewDataBinding binding = DataBindingUtil.inflate(
				LayoutInflater.from(parent.getContext()), viewType, parent,
				false);
		return new NewsViewHolder(binding);
	}

	@Override
	public void onBindViewHolder(NewsViewHolder holder, int position) {
		holder.bindModel(getData().get(position), position);
	}

	@Override
	public int getItemCount() {
		return data == null ? 0 : data.size();
	}

	public ObservableList<Product> getData() {
		return data;
	}

	private final ObservableList.OnListChangedCallback<ObservableList<Product>> itemChangedListener = new ObservableList.OnListChangedCallback<ObservableList<Product>>() {

		@Override
		public void onChanged(ObservableList<Product> news) {
			notifyDataSetChanged();
		}

		@Override
		public void onItemRangeChanged(ObservableList<Product> news, int start,
									   int count) {
			notifyItemRangeChanged(start, count);
		}

		@Override
		public void onItemRangeInserted(ObservableList<Product> news, int start,
										int count) {
			notifyItemRangeInserted(start, count);
		}

		@Override
		public void onItemRangeMoved(ObservableList<Product> news,
				int fromPosition, int toPosition, int itemCount) {
			notifyDataSetChanged();
		}

		@Override
		public void onItemRangeRemoved(ObservableList<Product> news, int start,
									   int count) {
			notifyItemRangeRemoved(start, count);
		}
	};

	class NewsViewHolder extends RecyclerView.ViewHolder {

		private final ViewDataBinding binding;
		private ProductVM productVM;

		NewsViewHolder(ViewDataBinding binding) {
			super(binding.getRoot());
			this.binding = binding;
			productVM = new ProductVM(navigator);
			binding.setVariable(BR.vm, productVM);
		}

		void bindModel(Product product, int pos) {
			productVM.setProduct(product);
			productVM.setPos(pos);
		}

	}
}
