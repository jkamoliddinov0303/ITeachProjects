package uz.jkamoliddinov0303.iteachprojects.ui.delivers

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import uz.jkamoliddinov0303.iteachprojects.R
import uz.jkamoliddinov0303.iteachprojects.databinding.DeliversFragmentBinding

class DeliversFragment : Fragment() {
    companion object {
        fun newInstance() = DeliversFragment()
    }

    private lateinit var viewModel: DeliversViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.delivers_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(DeliversViewModel::class.java)

    }

}