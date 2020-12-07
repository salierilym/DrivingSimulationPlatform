<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="驾驶实验表编号" prop="sid">
        <el-input
          v-model="queryParams.sid"
          placeholder="请输入驾驶实验表编号"
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
          v-hasPermi="['data:simulationdata:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['data:simulationdata:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['data:simulationdata:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['data:simulationdata:export']"
        >导出</el-button>
      </el-col>
	  <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="simulationdataList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="编号" align="center" prop="id" />
      <el-table-column label="驾驶实验表编号" align="center" prop="sid" />
      <el-table-column label="x坐标" align="center" prop="locX" />
      <el-table-column label="y坐标" align="center" prop="locY" />
      <el-table-column label="z坐标" align="center" prop="locZ" />
      <el-table-column label="车速" align="center" prop="speed" />
      <el-table-column label="x方向速度" align="center" prop="vx" />
      <el-table-column label="y方向速度" align="center" prop="vy" />
      <el-table-column label="z方向速度" align="center" prop="vz" />
      <el-table-column label="加速度" align="center" prop="a" />
      <el-table-column label="x方向加速度" align="center" prop="ax" />
      <el-table-column label="y方向加速度" align="center" prop="ay" />
      <el-table-column label="z方向加速度" align="center" prop="az" />
      <el-table-column label="档位" align="center" prop="gear" />
      <el-table-column label="转速" align="center" prop="rpm" />
      <el-table-column label="行驶里程" align="center" prop="traveledDistance" />
      <el-table-column label="时间戳" align="center" prop="simulationTime" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['data:simulationdata:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['data:simulationdata:remove']"
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

    <!-- 添加或修改驾驶数据对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="驾驶实验表编号" prop="sid">
          <el-input v-model="form.sid" placeholder="请输入驾驶实验表编号" />
        </el-form-item>
        <el-form-item label="x坐标" prop="locX">
          <el-input v-model="form.locX" placeholder="请输入x坐标" />
        </el-form-item>
        <el-form-item label="y坐标" prop="locY">
          <el-input v-model="form.locY" placeholder="请输入y坐标" />
        </el-form-item>
        <el-form-item label="z坐标" prop="locZ">
          <el-input v-model="form.locZ" placeholder="请输入z坐标" />
        </el-form-item>
        <el-form-item label="车速" prop="speed">
          <el-input v-model="form.speed" placeholder="请输入车速" />
        </el-form-item>
        <el-form-item label="x方向速度" prop="vx">
          <el-input v-model="form.vx" placeholder="请输入x方向速度" />
        </el-form-item>
        <el-form-item label="y方向速度" prop="vy">
          <el-input v-model="form.vy" placeholder="请输入y方向速度" />
        </el-form-item>
        <el-form-item label="z方向速度" prop="vz">
          <el-input v-model="form.vz" placeholder="请输入z方向速度" />
        </el-form-item>
        <el-form-item label="加速度" prop="a">
          <el-input v-model="form.a" placeholder="请输入加速度" />
        </el-form-item>
        <el-form-item label="x方向加速度" prop="ax">
          <el-input v-model="form.ax" placeholder="请输入x方向加速度" />
        </el-form-item>
        <el-form-item label="y方向加速度" prop="ay">
          <el-input v-model="form.ay" placeholder="请输入y方向加速度" />
        </el-form-item>
        <el-form-item label="z方向加速度" prop="az">
          <el-input v-model="form.az" placeholder="请输入z方向加速度" />
        </el-form-item>
        <el-form-item label="档位" prop="gear">
          <el-input v-model="form.gear" placeholder="请输入档位" />
        </el-form-item>
        <el-form-item label="转速" prop="rpm">
          <el-input v-model="form.rpm" placeholder="请输入转速" />
        </el-form-item>
        <el-form-item label="行驶里程" prop="traveledDistance">
          <el-input v-model="form.traveledDistance" placeholder="请输入行驶里程" />
        </el-form-item>
        <el-form-item label="时间戳" prop="simulationTime">
          <el-input v-model="form.simulationTime" placeholder="请输入时间戳" />
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
import { listSimulationdata, getSimulationdata, delSimulationdata, addSimulationdata, updateSimulationdata, exportSimulationdata } from "@/api/data/simulationdata";

export default {
  name: "Simulationdata",
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
      // 驾驶数据表格数据
      simulationdataList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        sid: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        sid: [
          { required: true, message: "驾驶实验表编号不能为空", trigger: "blur" }
        ],
        locX: [
          { required: true, message: "x坐标不能为空", trigger: "blur" }
        ],
        locY: [
          { required: true, message: "y坐标不能为空", trigger: "blur" }
        ],
        locZ: [
          { required: true, message: "z坐标不能为空", trigger: "blur" }
        ],
        speed: [
          { required: true, message: "车速不能为空", trigger: "blur" }
        ],
        vx: [
          { required: true, message: "x方向速度不能为空", trigger: "blur" }
        ],
        vy: [
          { required: true, message: "y方向速度不能为空", trigger: "blur" }
        ],
        vz: [
          { required: true, message: "z方向速度不能为空", trigger: "blur" }
        ],
        a: [
          { required: true, message: "加速度不能为空", trigger: "blur" }
        ],
        ax: [
          { required: true, message: "x方向加速度不能为空", trigger: "blur" }
        ],
        ay: [
          { required: true, message: "y方向加速度不能为空", trigger: "blur" }
        ],
        az: [
          { required: true, message: "z方向加速度不能为空", trigger: "blur" }
        ],
        gear: [
          { required: true, message: "档位不能为空", trigger: "blur" }
        ],
        rpm: [
          { required: true, message: "转速不能为空", trigger: "blur" }
        ],
        traveledDistance: [
          { required: true, message: "行驶里程不能为空", trigger: "blur" }
        ],
        simulationTime: [
          { required: true, message: "时间戳不能为空", trigger: "blur" }
        ]
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询驾驶数据列表 */
    getList() {
      this.loading = true;
      listSimulationdata(this.queryParams).then(response => {
        this.simulationdataList = response.rows;
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
        sid: null,
        locX: null,
        locY: null,
        locZ: null,
        speed: null,
        vx: null,
        vy: null,
        vz: null,
        a: null,
        ax: null,
        ay: null,
        az: null,
        gear: null,
        rpm: null,
        traveledDistance: null,
        simulationTime: null
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
      this.title = "添加驾驶数据";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getSimulationdata(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改驾驶数据";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateSimulationdata(this.form).then(response => {
              this.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addSimulationdata(this.form).then(response => {
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
      this.$confirm('是否确认删除驾驶数据编号为"' + ids + '"的数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(function() {
          return delSimulationdata(ids);
        }).then(() => {
          this.getList();
          this.msgSuccess("删除成功");
        })
    },
    /** 导出按钮操作 */
    handleExport() {
      const queryParams = this.queryParams;
      this.$confirm('是否确认导出所有驾驶数据数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(function() {
          return exportSimulationdata(queryParams);
        }).then(response => {
          this.download(response.msg);
        })
    }
  }
};
</script>
