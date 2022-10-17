package com.moessa.openLibrary.module.docs_list.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.moessa.openLibrary.R
import com.moessa.openLibrary.databinding.FragmentDocsListBinding
import com.moessa.openLibrary.module.docs_list.presentation.adapter.DocsAdapter
import com.moessa.openLibrary.module.docs_list.presentation.uimodel.mapper.toUiModel
import com.moessa.openLibrary.module.docs_list.presentation.viewmodel.DocsViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class DocsListFragment : Fragment() {

    private lateinit var binding: FragmentDocsListBinding
    private val viewModel by viewModels<DocsViewModel>()
    private lateinit var adapter: DocsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_docs_list, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeStateFlow()
        setupUI()
        viewModel.getDocsList("the lord of the rings")
    }

    private fun setupUI() {
        binding.rvDocs.layoutManager = LinearLayoutManager(context)
        binding.rvDocs.setHasFixedSize(true)
        adapter = DocsAdapter()
        binding.rvDocs.addItemDecoration(
            DividerItemDecoration(
                binding.rvDocs.context,
                (binding.rvDocs.layoutManager as LinearLayoutManager).orientation
            )
        )
        binding.rvDocs.adapter = adapter
    }

    private fun observeStateFlow() {

        lifecycleScope.launchWhenStarted {

            launch {
                viewModel.docsListStateFlow().collect { list ->
                    if (!list.isNullOrEmpty()) {
                        binding.rvDocs.visibility = View.VISIBLE
                        adapter.submitList(ArrayList(list.map { it.toUiModel() }))
                    }
                }
            }

            launch {
                viewModel.errorStateFlow().collect {
                    if (it != null) {
                        Toast.makeText(context, it.toString(), Toast.LENGTH_LONG).show()
                        it.printStackTrace()
                    }
                }
            }

            launch {
                viewModel.loadingStateFlow().collect {
                    binding.progressBar.visibility = if (it) View.VISIBLE else View.GONE
                }
            }
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            DocsListFragment()
    }
}