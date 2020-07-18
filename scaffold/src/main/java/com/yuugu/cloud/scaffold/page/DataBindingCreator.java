package com.yuugu.cloud.scaffold.page;

import android.util.SparseArray;

import androidx.lifecycle.ViewModel;

/**
 * @author: yuugu
 * @date: 2020/7/16
 */
public class DataBindingCreator {

    private int layout;

    private int vmVariableId;

    private ViewModel stateViewModel;

    private SparseArray<Object> bindingParams = new SparseArray<>();

    public DataBindingCreator(int layout, int vmVariableId, ViewModel stateViewModel) {
        this.layout = layout;
        this.vmVariableId = vmVariableId;
        this.stateViewModel = stateViewModel;
    }

    public int getLayout() {
        return layout;
    }

    public int getVmVariableId() {
        return vmVariableId;
    }

    public ViewModel getStateViewModel() {
        return stateViewModel;
    }

    public SparseArray<Object> getBindingParams() {
        return bindingParams;
    }

    public DataBindingCreator addBindingParam(int variableId, Object object) {
        if (bindingParams.get(variableId) == null) {
            bindingParams.put(variableId, object);
        }
        return this;
    }
}