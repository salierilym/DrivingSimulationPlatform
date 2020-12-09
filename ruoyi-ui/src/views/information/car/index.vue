<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="车辆名称" prop="carName">
        <el-input
          v-model="queryParams.carName"
          placeholder="请输入车辆名称"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="车辆类型" prop="carType">
        <el-input
          v-model="queryParams.carType"
          placeholder="请输入车辆类型"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item>
        <el-button type="cyan" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['information:car:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['information:car:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['information:car:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['information:car:export']"
        >导出</el-button>
      </el-col>
	  <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="carList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="编号" align="center" prop="id" />
      <el-table-column label="车辆名称" align="center" prop="carName" />
      <el-table-column label="车辆类型" align="center" prop="carType" />
      <el-table-column label="车辆全长(m)" align="center" prop="carLength" />
      <el-table-column label="车辆总宽(m)" align="center" prop="carWidth" />
      <el-table-column label="车辆总高(m)" align="center" prop="carHeight" />
      <el-table-column label="车辆轴距(m)" align="center" prop="carWheelbase" />
      <el-table-column label="车辆最大扭矩(Nm)" align="center" prop="carMaxtorque" />
      <el-table-column label="车辆最高转速(r/min)" align="center" prop="carMaxrpm" />
      <el-table-column label="车辆差速器类型" align="center" prop="carDifferential" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['information:car:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['information:car:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    
    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改车辆参数对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="车辆名称" prop="carName">
          <el-input v-model="form.carName" placeholder="请输入车辆名称" />
        </el-form-item>
        <el-form-item label="车辆类型" prop="carType">
          <el-input v-model="form.carType" placeholder="请输入车辆类型" />
        </el-form-item>
        <el-form-item label="车辆全长(m)" prop="carLength">
          <el-input v-model="form.carLength" placeholder="请输入车辆全长(m)" />
        </el-form-item>
        <el-form-item label="车辆总宽(m)" prop="carWidth">
          <el-input v-model="form.carWidth" placeholder="请输入车辆总宽(m)" />
        </el-form-item>
        <el-form-item label="车辆总高(m)" prop="carHeight">
          <el-input v-model="form.carHeight" placeholder="请输入车辆总高(m)" />
        </el-form-item>
        <el-form-item label="车辆轴距(m)" prop="carWheelbase">
          <el-input v-model="form.carWheelbase" placeholder="请输入车辆轴距(m)" />
        </el-form-item>
        <el-form-item label="车辆最大扭矩(Nm)" prop="carMaxtorque">
          <el-input v-model="form.carMaxtorque" placeholder="请输入车辆最大扭矩(Nm)" />
        </el-form-item>
        <el-form-item label="车辆最高转速(r/min)" prop="carMaxrpm">
          <el-input v-model="form.carMaxrpm" placeholder="请输入车辆最高转速(r/min)" />
        </el-form-item>
        <el-form-item label="车辆差速器类型" prop="carDifferential">
          <el-input v-model="form.carDifferential" placeholder="请输入车辆差速器类型" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listCar, getCar, delCar, addCar, updateCar, exportCar } from "@/api/information/car";

export default {
  name: "Car",
  components: {
  },
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 车辆参数表格数据
      carList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        carName: null,
        carType: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        carName: [
          { required: true, message: "车辆名称不能为空", trigger: "blur" }
        ],
        carType: [
          { required: true, message: "车辆类型不能为空", trigger: "blur" }
        ],
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询车辆参数列表 */
    getList() {
      this.loading = true;
      listCar(this.queryParams).then(response => {
        this.carList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        id: null,
        carName: null,
        carType: null,
        carLength: null,
        carWidth: null,
        carHeight: null,
        carWheelbase: null,
        carMaxtorque: null,
        carMaxrpm: null,
        carDifferential: null
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.id)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加车辆参数";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getCar(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改车辆参数";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateCar(this.form).then(response => {
              this.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addCar(this.form).then(response => {
              this.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const ids = row.id || this.ids;
      this.$confirm('是否确认删除车辆参数编号为"' + ids + '"的数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(function() {
          return delCar(ids);
        }).then(() => {
          this.getList();
          this.msgSuccess("删除成功");
        })
    },
    /** 导出按钮操作 */
    handleExport() {
      const queryParams = this.queryParams;
      this.$confirm('是否确认导出所有车辆参数数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(function() {
          return exportCar(queryParams);
        }).then(response => {
          this.download(response.msg);
        })
    }
  }
};
</script>
